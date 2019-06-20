package com.iapppay.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @className: TestController
 * @classDescription:
 * @author lishiqiang
 * @create_date: 2019年4月25日 下午4:27:16
 * @update_date:
 */
@Controller
public class TestController {

	@RequestMapping(path = "/consumer")
	@ResponseBody
	public String request() {
		return "hello world";
	}

}
