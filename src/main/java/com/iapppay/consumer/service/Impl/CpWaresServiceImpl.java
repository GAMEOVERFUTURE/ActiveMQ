package com.iapppay.consumer.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.iapppay.consumer.dao.dimdao.DimAppDistRulesMapper;
import com.iapppay.consumer.dao.dsdao.AppDistRuleMapper;
import com.iapppay.consumer.dao.dsdao.DsWaresMapper;
import com.iapppay.consumer.dto.dimdto.DimAppDistRules;
import com.iapppay.consumer.dto.dsdto.AppDistRule;
import com.iapppay.consumer.dto.dsdto.DsWares;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.entity.NULL;
import com.iapppay.consumer.framework.entity.request.CpWaresInfo;
import com.iapppay.consumer.framework.entity.request.CpWaresInfo.DistRule;
import com.iapppay.consumer.service.CommonService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: CpWarseServiceImpl
 * @classDescription:应用迁移，转让，新增服务类
 * @author lishiqiang
 * @create_date: 2019年5月14日 下午4:54:37
 * @update_date:
 */
@Slf4j
@Service
public class CpWaresServiceImpl implements CommonService<NULL, CpWaresInfo> {

	@Autowired
	private DsWaresMapper dsWaresMapper;

	@Autowired
	private AppDistRuleMapper appDistRuleMapper;

	@Autowired
	private DimAppDistRulesMapper appShareProfitRulesMapper;

	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Value("${iapppay.settlement.platId}")
	private Integer platId;

	@Value("${iapppay.settlement.acId}")
	private Integer acId;

	@Override
	public NULL service(List<CpWaresInfo> param, Map<String, Object> operat) throws ConsumerException {
		// 获取操作类型
		Date date = new Date();
		String optType = String.valueOf(operat.get(FieldNames.OPERATYPE));
		boolean isCommit = true;
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

		// 新增
		if (DbOperatTypeEnum.OPERAT_ADD.getValues().equals(optType)
				|| DbOperatTypeEnum.OPERAT_BATCH_ADD.getValues().equals(optType)) {
			for (CpWaresInfo cpWaresInfo : param) {
				checkData(cpWaresInfo);
				handlerAddInfo(cpWaresInfo, isCommit, status, date);
			}
		}

		// 修改(迁移,转让)
		if (DbOperatTypeEnum.OPERAT_TRANSFER.getValues().equals(optType)) {
			for (CpWaresInfo cpWaresInfo : param) {
				checkData(cpWaresInfo);
				handlerUpdateCpwaresInfo(cpWaresInfo, isCommit, status, date);
			}
		}

		// 修改应用状态
		if (DbOperatTypeEnum.OPERAT_UPDATE.getValues().equals(optType)
				|| DbOperatTypeEnum.OPERAT_BATCH_UPDATE.getValues().equals(optType)) {
			// 处理业务
			try {
				for (CpWaresInfo cpWaresInfo : param) {
					int count = dsWaresMapper.getExistDsWares(cpWaresInfo.getWaresid());
					if (count == 0) {
						log.error("waresid[{}],platid[{}]-->dsWares already exist,insert error!", cpWaresInfo.getWaresid(),
								platId);
						isCommit= false;
						throw ConsumerException.newInstance(ConsumerExceptionEnum.DSWARES_EXIST.code(), "waresid["
								+ cpWaresInfo.getWaresid() + "],platId[" + platId + "]-->dsWares not exist,insert error!");
					}

					DsWares dsWares = new DsWares();
					dsWares.setWaresid(cpWaresInfo.getWaresid());
					dsWares.setWaresstatus(cpWaresInfo.getWaresstatus());
					dsWares.setLastupdtime(date);
					dsWaresMapper.updateByPrimaryKeySelective(dsWares);
				}
			} finally {
				if (isCommit) {
					transactionManager.commit(status);
				} else {
					transactionManager.rollback(status);
				}
			}
		}

		return null;
	}

	/**
	 * 处理应用信息
	 * 
	 * @param cpWaresInfo
	 * @param isCommit
	 * @param status
	 * @throws ConsumerException
	 */
	private void handlerAddInfo(CpWaresInfo cpWaresInfo, boolean isCommit, TransactionStatus status, Date date)
			throws ConsumerException {
		// 判断是否已经存在
		int count = dsWaresMapper.getExistDsWares(cpWaresInfo.getWaresid());
		if (count > 0) {
			log.error("waresid[{}],platid[{}]-->dsWares already exist,insert error!", cpWaresInfo.getWaresid(), platId);
			throw ConsumerException.newInstance(ConsumerExceptionEnum.DSWARES_EXIST.code(), "waresid["
					+ cpWaresInfo.getWaresid() + "],platId[" + platId + "]-->dsWares already exist,insert error!");
		}

		// 处理业务
		try {
			DsWares dsWare = new DsWares();
			BeanUtils.copyProperties(cpWaresInfo, dsWare);
			dsWare.setCreatetime(date);
			List<DistRule> ruleList = cpWaresInfo.getDistrules();
			List<AppDistRule> appDistRuleList = new ArrayList<>();
			List<DimAppDistRules> appShareProfitRules = new ArrayList<>();
			if (ruleList != null && ruleList.size() > 0) {
				for (DistRule distRule : ruleList) {
					AppDistRule appDistRule = new AppDistRule();
					DimAppDistRules appShareProfitRule = new DimAppDistRules();
					BeanUtils.copyProperties(distRule, appDistRule);
					BeanUtils.copyProperties(distRule, appShareProfitRule);
					appDistRule.setCreatetime(date);
					appShareProfitRule.setStatus(Constants.RULE_STATUS_Y);
					appShareProfitRule.setCreatetime(date);
					appDistRuleList.add(appDistRule);
					appShareProfitRules.add(appShareProfitRule);
				}
			} else {
				// 添加默认分润规则
				AppDistRule appDistRule = new AppDistRule();
				DimAppDistRules appShareProfitRule = new DimAppDistRules();
				makeDefaultRules(cpWaresInfo, appDistRule, appShareProfitRule, date);
				appDistRuleList.add(appDistRule);
				appShareProfitRules.add(appShareProfitRule);
			}

			appDistRuleMapper.batchInsert(appDistRuleList);// 插入新的规则
			appShareProfitRulesMapper.batchInsert(appShareProfitRules);// 插入新的规则
			dsWaresMapper.insert(dsWare);
		} catch (Exception e) {
			isCommit = false;
			log.error("dsWares insert error--->{}", e.getMessage(), e);
			throw ConsumerException.newInstance(ConsumerExceptionEnum.DSWARES_INSERT_ERROR.code(),
					"dsWares insert error!");
		} finally {
			if (isCommit) {
				transactionManager.commit(status);
			} else {
				transactionManager.rollback(status);
			}
		}
	}


	/**
	 * 
	 * @param cpWaresInfo
	 * @param appDistRule
	 * @param appShareProfitRule
	 * @param createDate
	 */
	private void makeDefaultRules(CpWaresInfo cpWaresInfo, AppDistRule appDistRule,
			DimAppDistRules appShareProfitRule, Date createDate) {
		appDistRule.setAcid(acId);
		appDistRule.setAppid(cpWaresInfo.getWaresid());
		appDistRule.setCpid(cpWaresInfo.getCpid());
		appDistRule.setCreatetime(createDate);
		appDistRule.setDistrate(Constants.DEFUALT_DOUBLE_DISTRATE);
		appDistRule.setPlatid(platId);
		// ----------
		appShareProfitRule.setAcid(acId);
		appShareProfitRule.setAppid(cpWaresInfo.getWaresid());
		appShareProfitRule.setCpid(cpWaresInfo.getCpid());
		appShareProfitRule.setCreatetime(createDate);
		appShareProfitRule.setDistrate(Constants.DEFUALT_DISTRATE);
		appShareProfitRule.setStatus(Constants.RULE_STATUS_Y);
	}

	/**
	 * 应用迁移，修改，转让等
	 * 
	 * @param cpWaresInfo
	 * @param isCommit
	 * @param status
	 * @throws ConsumerException
	 */
	private void handlerUpdateCpwaresInfo(CpWaresInfo cpWaresInfo, boolean isCommit, TransactionStatus status,Date createdate)
			throws ConsumerException {
		// 判断是否存在 修改wares表中的数据 ，删除ds规则表中信息 ，修改rule表中的状态，插入ds和rule新的规则
		String waresId = cpWaresInfo.getWaresid();
		int count = dsWaresMapper.getExistDsWares(waresId);
		if (count == 0) {
			log.error("waresid[{}],platid[{}]-->dsWares not exist,insert error!", waresId, platId);
			throw ConsumerException.newInstance(ConsumerExceptionEnum.DSWARES_NULL.code(),
					"waresid[" + waresId + "],platId[" + platId + "]-->dsWares not exist,insert error!");
		}

		// 处理业务
		try {
			// 组装应用和规则信息
			Map<String,Object> ruleMap = new HashMap<String,Object>();
			ruleMap.put(FieldNames.APPID, waresId);
			DsWares dswares = new DsWares();
			List<AppDistRule> appDistRuleList = new ArrayList<>();
			List<DimAppDistRules> appShareProfitRules = new ArrayList<>();
			processDsWaresAndRulesInfo(cpWaresInfo, dswares, appDistRuleList, appShareProfitRules, createdate);

			// 更改
			dsWaresMapper.updateByPrimaryKeySelective(dswares);//修改应用信息
			appDistRuleMapper.deleteRulesByParams(ruleMap);//删除ds表中的数据
			appShareProfitRulesMapper.updateShateProfitStatus(ruleMap);//更改之前应用分润规则为不可用
			appDistRuleMapper.batchInsert(appDistRuleList);// 插入新的规则
			appShareProfitRulesMapper.batchInsert(appShareProfitRules);// 插入新的规则
		} catch (Exception e) {
			isCommit = false;
			log.error("dsWares update or migration or transfer error--->{}", e.getMessage(), e);
			throw ConsumerException.newInstance(ConsumerExceptionEnum.DSWARES_UPDATE_ERROR.code(),
					"dsWares update or migration or transfer error!");
		} finally {
			if (isCommit) {
				transactionManager.commit(status);
			} else {
				transactionManager.rollback(status);
			}
		}
	}

	/**
	 * 组装应用迁移数据
	 * 
	 * @param cpWaresInfo
	 * @param dswares
	 * @param appDistRule
	 * @param appShareProfitRules
	 * @throws ConsumerException
	 */
	private void processDsWaresAndRulesInfo(CpWaresInfo cpWaresInfo, DsWares dswares, List<AppDistRule> appDistRules,
			List<DimAppDistRules> appShareProfitRules, Date createdate) throws ConsumerException {
		BeanUtils.copyProperties(cpWaresInfo, dswares);
		List<DistRule> ruleList = cpWaresInfo.getDistrules();
		if (ruleList != null && ruleList.size() > 0) {
			for (DistRule distRule : ruleList) {
				AppDistRule appDistRule = new AppDistRule();
				DimAppDistRules appShareProfitRule = new DimAppDistRules();
				BeanUtils.copyProperties(distRule, appDistRule);
				BeanUtils.copyProperties(distRule, appShareProfitRule);
				appDistRule.setCreatetime(createdate);
				appShareProfitRule.setCreatetime(createdate);
				appShareProfitRule.setStatus(Constants.RULE_STATUS_Y);
				appDistRules.add(appDistRule);
				appShareProfitRules.add(appShareProfitRule);
			}
		} else {
			// 添加默认分润规则
			AppDistRule appDistRule = new AppDistRule();
			DimAppDistRules appShareProfitRule = new DimAppDistRules();
			makeDefaultRules(cpWaresInfo, appDistRule, appShareProfitRule, createdate);
			appDistRules.add(appDistRule);
			appShareProfitRules.add(appShareProfitRule);
		}
	}

	/**
	 * 核查数据
	 * 
	 * @param cpWaresInfo
	 * @throws ConsumerException
	 */
	private void checkData(CpWaresInfo cpWaresInfo) throws ConsumerException {
		List<DistRule> ruleList = cpWaresInfo.getDistrules();
		if (ruleList != null && ruleList.size() > 0) {
			Set<String> set = new HashSet<>();
			for (DistRule distRule : ruleList) {
				if (!distRule.getAppid().equals(cpWaresInfo.getWaresid())) {
					throw ConsumerException.newInstance("inconsistency of data-->share profit rule:appid[{"
							+ distRule.getAppid() + "}],cpwaresInfo appid[{" + cpWaresInfo.getWaresid() + "}]");
				}
				String checkId = distRule.getAppid()+distRule.getAcid()+distRule.getPlatid();
				set.add(checkId);
			}
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) {
				int i = 0;
				String keyId = iterator.next();
				for (DistRule distRule : ruleList) {
					String checkId = distRule.getAppid() + distRule.getAcid() + distRule.getPlatid();
					if (checkId.equals(keyId)) {
						i = i + distRule.getDistrate().intValue();
					}
				}
				if (i != Constants.DEFUALT_DOUBLE_DISTRATE) {
					throw ConsumerException.newInstance("share profit distrate sum not correct");
				}
			}
		}
	}
}
