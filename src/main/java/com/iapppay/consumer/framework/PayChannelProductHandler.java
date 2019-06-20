package com.iapppay.consumer.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iapppay.consumer.common.FieldNames;
import com.iapppay.consumer.dao.dimdao.DimPaychanRefMapper;
import com.iapppay.consumer.dto.dimdto.DimPaychanRef;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: PayChannelProductHandler
 * @classDescription:更新缓存
 * @author lishiqiang
 * @create_date: 2019年5月7日 下午1:54:26
 * @update_date:
 */
@Slf4j
public class PayChannelProductHandler implements Runnable {

	private DimPaychanRefMapper dimPaychanRefMapper;

	public PayChannelProductHandler(DimPaychanRefMapper dimPaychanRefMapper) {
		this.dimPaychanRefMapper = dimPaychanRefMapper;
	}

	@Override
	public void run() {
		try {
			List<DimPaychanRef> dimPayList = dimPaychanRefMapper.findAllDimPayChanRef();
			Map<String, Object> map = new HashMap<>();
			PayChannelProductCache.clear();
			for (DimPaychanRef dimPaychanRef : dimPayList) {
				map.clear();
				map.put(FieldNames.SETTLE_CHANNEL_ID, dimPaychanRef.getSettlechannelid());
				map.put(FieldNames.SETTLE_CHANNEL_NAME, dimPaychanRef.getSettlechannelname());
				map.put(FieldNames.PAYTYPE, dimPaychanRef.getPaytype());
				map.put(FieldNames.PAYTYPENAME, dimPaychanRef.getPaytypename());
				map.put(FieldNames.ID, dimPaychanRef.getId());
				PayChannelProductCache.setCache(String.valueOf(dimPaychanRef.getSettlechannelid().intValue()), map);
			}
		} catch (Exception e) {
			log.error("update payChannel cache error--->{}", e.getMessage(), e);
		}
	}

}
