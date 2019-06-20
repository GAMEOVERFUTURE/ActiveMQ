package com.iapppay.consumer.utils;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @className: SequenceGenerator
 * @classDescription:
 * @author lishiqiang  
 * @create_date: 2019年5月17日 下午3:55:20 
 * @update_date:
 */
public class SequenceGeneratorUtils {


	/**
	 * 简易生成唯一序列号
	 * 
	 * @return
	 */
	public static String generatorSequence() {
		Random random = new Random();
		String sequence = DateUtils.formatDate(new Date());
		String currenTime = String.valueOf(System.currentTimeMillis());
		sequence = sequence + currenTime.substring(currenTime.length() - 4) + String.valueOf(random.nextInt(99));
		return sequence;
	}
}
