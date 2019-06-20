package com.iapppay.consumer.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.iapppay.consumer.common.Constants;
import com.iapppay.consumer.common.ConsumerExceptionEnum;
import com.iapppay.consumer.common.DbOperatTypeEnum;
import com.iapppay.consumer.common.FieldNames;
import com.iapppay.consumer.dao.dimdao.YqzlCpPayInfoMapper;
import com.iapppay.consumer.dao.dsdao.DsCpBankMapper;
import com.iapppay.consumer.dto.dimdto.YqzlCpPayInfo;
import com.iapppay.consumer.dto.dimdto.YqzlCpPayInfoKey;
import com.iapppay.consumer.dto.dsdto.DsCpBank;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.entity.request.BankInfo;
import com.iapppay.consumer.framework.entity.response.ResponseBody;
import com.iapppay.consumer.service.CommonService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: BankInfoServiceImpl
 * @classDescription:银行账号服务类
 * @author lishiqiang
 * @create_date: 2019年4月26日 下午2:34:40
 * @update_date:
 */
@Service
@Slf4j
public class CpBankServiceImpl implements CommonService<ResponseBody, BankInfo> {
	
	@Autowired
	private DsCpBankMapper DsCpBankMapper;
	
	@Autowired
	private YqzlCpPayInfoMapper YqzlCpPayInfoMapper;

	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Value("${iapppay.settlement.platId}")
	private Integer platId;

	@Override
	public ResponseBody service(List<BankInfo> param, Map<String, Object> operat) throws ConsumerException {

		// 获取操作类型
		boolean isCommit = true;
		ResponseBody responseBody = new ResponseBody();
		String optType = String.valueOf(operat.get(FieldNames.OPERATYPE));
		String sequence = String.valueOf(operat.get(FieldNames.SEQUENCE));
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("CpBankService sequence[{}] optType -->[{}]", sequence, optType);

		// 新增
		if (DbOperatTypeEnum.OPERAT_ADD.getValues().equals(optType)
				|| DbOperatTypeEnum.OPERAT_BATCH_ADD.getValues().equals(optType)) {
			for (BankInfo bankInfo : param) {
				handlerAddBankInfo(bankInfo, isCommit, status, responseBody);
			}
			if (!ConsumerExceptionEnum.SUCCESS.code().equals(responseBody.getRespCode())) {
				return responseBody;
			}
			responseBody.setRespCode(ConsumerExceptionEnum.SUCCESS.code());
			responseBody.setRespMessage("cpBank add --->" + ConsumerExceptionEnum.SUCCESS.message());
		}

		// 修改
		if (DbOperatTypeEnum.OPERAT_UPDATE.getValues().equals(optType)
				|| DbOperatTypeEnum.OPERAT_BATCH_UPDATE.getValues().equals(optType)) {
			for (BankInfo bankInfo : param) {
				DsCpBank dcCpBank = new DsCpBank();
				BeanUtils.copyProperties(bankInfo, dcCpBank);
				handlerUpdateBankInfo(dcCpBank, isCommit, status, responseBody);
			}
			if (!ConsumerExceptionEnum.SUCCESS.code().equals(responseBody.getRespCode())) {
				return responseBody;
			}
			responseBody.setRespCode(ConsumerExceptionEnum.SUCCESS.code());
			responseBody.setRespMessage("cpBank update --->" + ConsumerExceptionEnum.SUCCESS.message());
		}

		return responseBody;
	}

	/**
	 * 组装DIM层CP_BANK对象
	 * 
	 * @param yqzlCpPayInfo
	 * @param bankInfo
	 */
	private void makePayInfo(YqzlCpPayInfo yqzlCpPayInfo, BankInfo bankInfo) {
		yqzlCpPayInfo.setAreaflag(Constants.AREA_FLAG_DEFAULT);
		yqzlCpPayInfo.setBankflag(Constants.BANK_FLAG_DEFAULT);
		yqzlCpPayInfo.setCpid(bankInfo.getCpid());
		yqzlCpPayInfo.setLastupdatetime(new Date());
		yqzlCpPayInfo.setPlatid(platId);
		yqzlCpPayInfo.setRcvaccount(bankInfo.getAccountid().replace(" ", ""));
		yqzlCpPayInfo.setRcvaccountname(bankInfo.getAccountname());
		yqzlCpPayInfo.setRcvopenbank(bankInfo.getBankname());
		yqzlCpPayInfo.setUpdateby(Constants.UPDATE_BY_DEFAULT);
	}

	/**
	 * 
	 * @param bankInfo
	 * @param isCommit
	 * @param status
	 * @throws ConsumerException
	 */
	private void handlerAddBankInfo(BankInfo bankInfo, boolean isCommit, TransactionStatus status,
			ResponseBody responseBody) throws ConsumerException {
		YqzlCpPayInfoKey key = new YqzlCpPayInfoKey();
		DsCpBank dcCpBank = new DsCpBank();
		YqzlCpPayInfo yqzlCpPayInfo = new YqzlCpPayInfo();
		BeanUtils.copyProperties(bankInfo, dcCpBank);

		// 判断是否已经存在
		DsCpBank dsCpBankQuery = DsCpBankMapper.selectByPrimaryKey(bankInfo.getCpid());
		key.setCpid(bankInfo.getCpid());
		key.setPlatid(platId);
		YqzlCpPayInfo yqzlCpPayInfoQuery = YqzlCpPayInfoMapper.selectByPrimaryKey(key);
		if (dsCpBankQuery != null || yqzlCpPayInfoQuery != null) {
			responseBody.setRespCode(ConsumerExceptionEnum.CP_BANK_EXIST.code());
			responseBody.setRespMessage("cpid["+dcCpBank.getCpid()+"]"+ConsumerExceptionEnum.CP_BANK_EXIST.message());
			return;
		}

		try {
			DsCpBankMapper.insert(dcCpBank);
			makePayInfo(yqzlCpPayInfo, bankInfo);
			YqzlCpPayInfoMapper.insert(yqzlCpPayInfo);
		} catch (Exception e) {
			isCommit = false;
			throw ConsumerException.newInstance(ConsumerExceptionEnum.MYSQL_ERROR.code(),
					ConsumerExceptionEnum.MYSQL_ERROR.message());
		} finally {
			if (isCommit) {
				transactionManager.commit(status);
			} else {
				transactionManager.rollback(status);
			}
		}
	}

	/**
	 * 处理更新服务
	 * 
	 * @param dcCpBank
	 * @param isCommit
	 * @param status
	 * @throws ConsumerException
	 */
	private void handlerUpdateBankInfo(DsCpBank dcCpBank, boolean isCommit, TransactionStatus status,
			ResponseBody responseBody) throws ConsumerException {
		YqzlCpPayInfo yqzlCp = new YqzlCpPayInfo();
		YqzlCpPayInfoKey yqzlCpkey = new YqzlCpPayInfoKey();
		DsCpBank dsCpBankQuery = DsCpBankMapper.selectByPrimaryKey(dcCpBank.getCpid());
		yqzlCpkey.setCpid(dcCpBank.getCpid());
		yqzlCpkey.setPlatid(platId);
		YqzlCpPayInfo yqzlCpPayInfoQuery = YqzlCpPayInfoMapper.selectByPrimaryKey(yqzlCpkey);

		if (dsCpBankQuery != null && yqzlCpPayInfoQuery != null) {
			responseBody.setRespCode(ConsumerExceptionEnum.CP_BANK_EXIST.code());
			responseBody.setRespMessage("cpid["+dcCpBank.getCpid()+"]--->dsCpBank or yqzlCpPayInfo is null,update error!");
			return;
		}

		try {
			// 修改数据
			DsCpBankMapper.updateByPrimaryKeySelective(dcCpBank);
			yqzlCp.setCpid(dcCpBank.getCpid());
			yqzlCp.setPlatid(platId);
			yqzlCp.setLastupdatetime(new Date());
			yqzlCp.setRcvaccount(dcCpBank.getAccountid().replace(" ", ""));
			yqzlCp.setRcvaccountname(dcCpBank.getAccountname());
			yqzlCp.setRcvopenbank(dcCpBank.getBankname());
			YqzlCpPayInfoMapper.updateByPrimaryKeySelective(yqzlCp);
		} catch (Exception e) {
			isCommit = false;
			throw ConsumerException.newInstance(ConsumerExceptionEnum.MYSQL_ERROR.code(),
					ConsumerExceptionEnum.MYSQL_ERROR.message());
		} finally {
			if (isCommit) {
				transactionManager.commit(status);
			} else {
				transactionManager.rollback(status);
			}
		}
	}
}
