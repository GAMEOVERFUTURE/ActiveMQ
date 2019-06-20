package com.iapppay.consumer.service.Impl;

import java.util.ArrayList;
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
import com.iapppay.consumer.dao.dsdao.DsCpAccoRulesMapper;
import com.iapppay.consumer.dao.dsdao.DsCpContractMapper;
import com.iapppay.consumer.dao.dsdao.DsCpPayChanMapper;
import com.iapppay.consumer.dto.dsdto.DsCpAccoRules;
import com.iapppay.consumer.dto.dsdto.DsCpContract;
import com.iapppay.consumer.dto.dsdto.DsCpPayChan;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.PayChannelProductCache;
import com.iapppay.consumer.framework.entity.NULL;
import com.iapppay.consumer.framework.entity.request.ContractInfo;
import com.iapppay.consumer.framework.entity.request.CpAccoRulesInfo;
import com.iapppay.consumer.framework.entity.request.CpContractInfo;
import com.iapppay.consumer.framework.entity.request.CpPayChanInfo;
import com.iapppay.consumer.service.CommonService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: CpContractServiceImpl
 * @classDescription:回滚合同信息服务类
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午3:30:37
 * @update_date:
 */
@Service
@Slf4j
public class CpContractServiceImpl implements CommonService<NULL, ContractInfo> {

	@Autowired
	private DsCpAccoRulesMapper dsCpAccoRulesMapper;

	@Autowired
	private DsCpContractMapper dsCpContractMapper;

	@Autowired
	private DsCpPayChanMapper dsCpPayChanMapper;

	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Value("${iapppay.settlement.platId}")
	private Integer platId;

	@Override
	public NULL service(List<ContractInfo> param, Map<String, Object> operat) throws ConsumerException {
		// 获取操作类型
		String optType = String.valueOf(operat.get(FieldNames.OPERATYPE));
		boolean isCommit = true;
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

		// 新增
		if (DbOperatTypeEnum.OPERAT_ADD.getValues().equals(optType)
				|| DbOperatTypeEnum.OPERAT_BATCH_ADD.getValues().equals(optType)) {
			for (ContractInfo contractInfo : param) {
				handlerInfo(contractInfo, isCommit, status);
			}
		}

		// 修改
		if (DbOperatTypeEnum.OPERAT_UPDATE.getValues().equals(optType)
				|| DbOperatTypeEnum.OPERAT_BATCH_UPDATE.getValues().equals(optType)) {
			for (ContractInfo contractInfo : param) {
				// BeanUtils.copyProperties(bankInfo, dcCpBank);
				// handlerUpdateCpBaseInfo(cpBaseInfo, isCommit, status);
			}
		}

		return null;
	}

	/**
	 * 处理合同相关信息
	 * 
	 * @param contractInfo
	 * @param isCommit
	 * @param status
	 * @throws ConsumerException
	 */
	private void handlerInfo(ContractInfo contractInfo, boolean isCommit, TransactionStatus status)
			throws ConsumerException {
		CpContractInfo cpContractInfo = contractInfo.getCpContractInfo();
		List<CpPayChanInfo> cpPayChanList = contractInfo.getPayChanList();
		List<CpAccoRulesInfo> rulesList = contractInfo.getRulesList();

		Integer cpId = cpContractInfo.getCpid();

		// 判断是否已经存在
		if (cpId == null || cpId <= 0) {
			throw ConsumerException.newInstance(ConsumerExceptionEnum.CP_ID_NULL.code(),
					"cpContract add:" + ConsumerExceptionEnum.CP_ID_NULL.message());
		}
		DsCpContract dsCpContract = dsCpContractMapper.selectByPrimaryKey(cpId);
		if (dsCpContract == null) {
			try {
				// 处理业务
				DsCpContract dsCpContractAdd = new DsCpContract();
				BeanUtils.copyProperties(cpContractInfo, dsCpContractAdd);
				if (Integer.valueOf(1).equals(dsCpContractAdd.getContraaudistatus())) { // 如果审核通过 则默认为是正式合同
					dsCpContractAdd.setContratype(1); // 正式合同
					if (org.apache.commons.lang3.StringUtils.isEmpty(dsCpContractAdd.getBalacyctype())) { // 如果为正式合同并且结算周期为空，默认为月结
						dsCpContractAdd.setBalacyctype(Constants.BALACYCTYPE_MONTH);
					}
				}
				// web这个字段存的元，到结算转成分
				if (dsCpContractAdd.getLowpaymoney() != null) {
					dsCpContractAdd.setLowpaymoney(dsCpContractAdd.getLowpaymoney() * Constants.MULTIPLY_PARAM);
				}
				
				List<DsCpAccoRules> accRuleList  = new ArrayList<>();
				List<DsCpPayChan> payChanList  = new ArrayList<>();
				handlerList(cpPayChanList, rulesList, accRuleList, payChanList);
				dsCpAccoRulesMapper.foreachInsert(accRuleList);
				dsCpPayChanMapper.foreachInsert(payChanList);
				dsCpContractMapper.insert(dsCpContractAdd);
			} catch (Exception e) {
				isCommit = false;
				log.error("DsCpContract insert error--->{}", e.getMessage(), e);
			} finally {
				if (isCommit) {
					transactionManager.commit(status);
				} else {
					transactionManager.rollback(status);
				}
			}
		} else {
			// 存在不处理 并输出日志
			log.warn("cpid[{}],platid[{}]-->dsCpBank or yqzlCpPayInfo already exist,insert error!", cpId,
					platId);
		}
	}

	/**
	 * 
	 * @param cpPayChanList
	 * @param rulesList
	 * @param accRuleList
	 * @param payChanList
	 */
	private void handlerList(List<CpPayChanInfo> cpPayChanList, List<CpAccoRulesInfo> rulesList,
			List<DsCpAccoRules> accRuleList, List<DsCpPayChan> payChanList) {
		for(CpPayChanInfo cpPayChanInfo:cpPayChanList) {
			DsCpPayChan dscpPayChan = new DsCpPayChan();
			BeanUtils.copyProperties(cpPayChanInfo, dscpPayChan);
			if (dscpPayChan.getPaytype() == null) {
				Map<String, Object> paytypeMap = PayChannelProductCache.getCache(String.valueOf(dscpPayChan.getPlatchanno()));
				// 查询不到应该抛出异常才对
				Double payType = (Double) paytypeMap.get(FieldNames.PAYTYPE);
				dscpPayChan.setPaytype(payType.intValue());
			}
			payChanList.add(dscpPayChan);
		}

		for (CpAccoRulesInfo cpAccoRulesInfo : rulesList) {
			DsCpAccoRules dsCpAccoRules = new DsCpAccoRules();
			BeanUtils.copyProperties(cpAccoRulesInfo, dsCpAccoRules);
			accRuleList.add(dsCpAccoRules);
		}
	}

}
