package com.iapppay.consumer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @className: DateUtils
 * @classDescription:时间工具类
 * @author lishiqiang
 * @create_date: 2019年5月7日 上午10:02:29
 * @update_date:
 */
public class DateUtils {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	public static Integer formatDateToInteger(Date date) {
		return Integer.parseInt(simpleDateFormat.format(date));
	}

	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}

}
