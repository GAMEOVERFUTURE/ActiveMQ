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

import com.iapppay.consumer.common.BelongSystemEnum;
import com.iapppay.consumer.common.CpModeEnum;
import com.iapppay.consumer.common.DbOperatTypeEnum;
import com.iapppay.consumer.common.FieldNames;
import com.iapppay.consumer.dao.dimdao.DimDayCpInfoMapper;
import com.iapppay.consumer.dao.dsdao.DsCpBaseMapper;
import com.iapppay.consumer.dto.dimdto.DimDayCpInfo;
import com.iapppay.consumer.dto.dsdto.DsCpBase;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.entity.NULL;
import com.iapppay.consumer.framework.entity.request.CpBaseInfo;
import com.iapppay.consumer.service.CommonService;
import com.iapppay.consumer.utils.DateUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: CpBaseServiceImpl
 * @classDescription:商户基本信息服务类
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午3:29:12
 * @update_date:
 */
@Service
@Slf4j
public class CpBaseServiceImpl implements CommonService<NULL, CpBaseInfo> {

	@Autowired
	private DimDayCpInfoMapper dimDayCpInfoMapper;

	@Autowired
	private DsCpBaseMapper dsCpBaseMapper;

	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Value("${iapppay.settlement.platId}")
	private Integer platId;

	@Override
	public NULL service(List<CpBaseInfo> param, Map<String, Object> operat) throws ConsumerException {
		// 获取操作类型
		String optType = String.valueOf(operat.get(FieldNames.OPERATYPE));
		boolean isCommit = true;
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

		// 新增
		if (DbOperatTypeEnum.OPERAT_ADD.getValues().equals(optType)
				|| DbOperatTypeEnum.OPERAT_BATCH_ADD.getValues().equals(optType)) {
			for (CpBaseInfo cpBaseInfo : param) {
				handlerAddCpBaseInfo(cpBaseInfo, isCommit, status);
			}
		}

		// 修改
		if (DbOperatTypeEnum.OPERAT_UPDATE.getValues().equals(optType)
				|| DbOperatTypeEnum.OPERAT_BATCH_UPDATE.getValues().equals(optType)) {
			for (CpBaseInfo cpBaseInfo : param) {
				// BeanUtils.copyProperties(bankInfo, dcCpBank);
				handlerUpdateCpBaseInfo(cpBaseInfo, isCommit, status);
			}
		}
		return null;
	}

	/**
	 * @param cpBaseInfo
	 * @param isCommit
	 * @param status
	 */
	private void handlerAddCpBaseInfo(CpBaseInfo cpBaseInfo, boolean isCommit, TransactionStatus status) {
		// 判断是否已经存在
		DsCpBase dsCpbase = dsCpBaseMapper.selectByPrimaryKey(cpBaseInfo.getCpid());
		if (dsCpbase != null) {
			try {
				DsCpBase base = new DsCpBase();
				DimDayCpInfo dimDayCpInfo = new DimDayCpInfo();
				BeanUtils.copyProperties(cpBaseInfo, base);
				makeDimDayCpInfo(base, dimDayCpInfo);
				dsCpBaseMapper.insert(base);
				dimDayCpInfoMapper.insert(dimDayCpInfo);
			} catch (Exception e) {
				isCommit = false;
				log.error("dsCpBase or DimDayCpInfo insert error--->{}", e.getMessage(), e);
			} finally {
				if (isCommit) {
					transactionManager.commit(status);
				} else {
					transactionManager.rollback(status);
				}
			}
		} else {
			// 存在不处理 并输出日志
			log.warn("cpid[{}],platid[{}]-->dsCpbase already exist,insert error!",
					cpBaseInfo.getCpid(), platId);
		}
	}

	/**
	 * @param cpBaseInfo
	 * @param isCommit
	 * @param status
	 */
	private void handlerUpdateCpBaseInfo(CpBaseInfo cpBaseInfo, boolean isCommit, TransactionStatus status) {
		// 判断是否已经存在
		DsCpBase dsCpbase = dsCpBaseMapper.selectByPrimaryKey(cpBaseInfo.getCpid());
		if (dsCpbase != null) {
			try {
				DsCpBase base = new DsCpBase();
				BeanUtils.copyProperties(cpBaseInfo, base);
				dsCpBaseMapper.updateByPrimaryKeySelective(base);
			} catch (Exception e) {
				isCommit = false;
				log.error("");
			} finally {
				if (isCommit) {
					transactionManager.commit(status);
				} else {
					transactionManager.rollback(status);
				}
			}
		} else {
			// 不存在不处理 并输出日志
			log.warn("cpid[{}],platid[{}]-->dsCpBase not exist,update error!");
		}
	}

	/**
	 * 组装DIM商户基本信息
	 * 
	 * @param base
	 * @param dimDayCpInfo
	 */
	private void makeDimDayCpInfo(DsCpBase base, DimDayCpInfo dimDayCpInfo) {
		Date date = new Date();
		// dimDayCpInfo.setAgentcompanycode(agentcompanycode);
		// dimDayCpInfo.setAuditeffect(auditeffect);
		// dimDayCpInfo.setBalacyctype(balacyctype);
		// dimDayCpInfo.setBalacyctypetime(balacyctypetime);
		// dimDayCpInfo.setBalacyctypevalue(balacyctypevalue);
		// dimDayCpInfo.setBalacyctyptime(balacyctyptime);
		// dimDayCpInfo.setBalacyctypvalue(balacyctypvalue);
		// dimDayCpInfo.setBalancecall(balancecall);
		// dimDayCpInfo.setBindemail(bindemail);
		// dimDayCpInfo.setBussinesstype(base.getBussinesstype());
		// dimDayCpInfo.setContbegtime(contbegtime);
		// dimDayCpInfo.setContendtime(contendtime);
		// dimDayCpInfo.setContraaudistatus(contraaudistatus);
		// dimDayCpInfo.setContratype(contratype);
		dimDayCpInfo.setCpid(base.getCpid());
		dimDayCpInfo.setCplevel(base.getCplevel());
		dimDayCpInfo.setCpmode(CpModeEnum.NET_SALES.getValue());
		dimDayCpInfo.setCpname(base.getCpname());
		dimDayCpInfo.setCpstatus(base.getCpstatus());
		dimDayCpInfo.setCptype(base.getCptype());
		dimDayCpInfo.setCpunit(base.getCpunit());
		// dimDayCpInfo.setEffectivetime(effectivetime);
		dimDayCpInfo.setExcpid(base.getExcpid());
		// dimDayCpInfo.setFeecontr(feecontr);
		// dimDayCpInfo.setFormaltime(formaltime);
		// dimDayCpInfo.setFreebegtime(freebegtime);
		// dimDayCpInfo.setFreeendtime(freeendtime);
		dimDayCpInfo.setIftest(base.getIftest());
		dimDayCpInfo.setInserttime(date);
		// dimDayCpInfo.setIsautorene(isautorene);
		// dimDayCpInfo.setLowpaymoney(lowpaymoney);
		dimDayCpInfo.setParentcpid(base.getParentcpid() != null ? base.getParentcpid() : 0);
		// dimDayCpInfo.setRefundrule(refundrule);
		dimDayCpInfo.setRegtime(base.getRegtime());
		// dimDayCpInfo.setServtype(servtype);
		dimDayCpInfo.setStatdate(DateUtils.formatDateToInteger(date));
		dimDayCpInfo.setSystemid(base.getSystemid() == null ? BelongSystemEnum.DEFAULT.getValue() : base.getSystemid());
		// dimDayCpInfo.setUpdatetime(updatetime);
	}

}
