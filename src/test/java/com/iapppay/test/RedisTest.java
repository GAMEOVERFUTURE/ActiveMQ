package com.iapppay.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iapppay.consumer.redis.RedisUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class RedisTest {

	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void test() {
		// redisUtils.set("lsq_zhengshi_dbkey", 12);

		Object value = redisUtils.get("SYSTEM_CONFIG_MAP_KEY");

		System.out.println("======" + value.toString());
	}

}
