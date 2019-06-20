package com.iapppay.consumer.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iapppay.consumer.common.FieldNames;
import com.iapppay.consumer.dao.dimdao.DimPaychanRefMapper;
import com.iapppay.consumer.dto.dimdto.DimPaychanRef;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: PayChannelProductCache
 * @classDescription:支付通道产品大类内部缓存
 * @author lishiqiang
 * @create_date: 2019年5月7日 上午11:41:44
 * @update_date:
 */
@Slf4j
@Component
public class PayChannelProductCache implements InitializingBean, DisposableBean {
	/**
	 * 缓存对象
	 */
	private static final Map<String, Object> CACHE_OBJECT_MAP = new ConcurrentHashMap<>();

	/**
	 * 创建线程池
	 */
	private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5,
			new MyNameFactory("pay-Channel-product"));

	@Autowired
	private DimPaychanRefMapper dimPaychanRefMapper;

	public void init() {
		try {
			List<DimPaychanRef> dimPayList = dimPaychanRefMapper.findAllDimPayChanRef();
			Map<String, Object> map = new HashMap<>();
			clear();
			for (DimPaychanRef dimPaychanRef : dimPayList) {
				map.clear();
				map.put(FieldNames.SETTLE_CHANNEL_ID, dimPaychanRef.getSettlechannelid());
				map.put(FieldNames.SETTLE_CHANNEL_NAME, dimPaychanRef.getSettlechannelname());
				map.put(FieldNames.PAYTYPE, dimPaychanRef.getPaytype());
				map.put(FieldNames.PAYTYPENAME, dimPaychanRef.getPaytypename());
				map.put(FieldNames.ID, dimPaychanRef.getId());
				setCache(String.valueOf(dimPaychanRef.getSettlechannelid().intValue()), map);
			}
		} catch (Exception e) {
			log.error("update payChannel cache error--->{}", e.getMessage(), e);
		}
	}

	public static void clear() {
		CACHE_OBJECT_MAP.clear();
	}

	public static void setCache(String cacheKey, Object value) {
		log.info("have set cache[{}]", cacheKey);
		CACHE_OBJECT_MAP.put(cacheKey, value);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getCache(String cacheKey) {
		return (Map<String, Object>) CACHE_OBJECT_MAP.get(cacheKey);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		init();
		this.scheduledThreadPool.scheduleWithFixedDelay(new PayChannelProductHandler(dimPaychanRefMapper), 500, 360000,
				TimeUnit.SECONDS);
	}

	@Override
	public void destroy() throws Exception {
		this.scheduledThreadPool.shutdown();
	}

}
