package com.intro.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intro.web.command.Command;
import com.intro.web.mapper.TestMapper;
import com.intro.web.service.IGetService;

@RestController
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired TestMapper mapper;
	@Autowired Command cmd;
	
	@RequestMapping("/list/{cate}")
	public @ResponseBody Map<?, ?> count(@PathVariable String cate) {
		logger.info("TestController 진입: list : "+cate);
		Map<String, Object> map = new HashMap<>();
		
		map.put("count", new IGetService() {
			@Override
			public Object execute(Object o) {
				return mapper.count(cmd);
			}
		}.execute(cmd));
		
		System.out.println(map.get("count"));
		
		map.put("flag", "success");
		
		return map;
	}
	
}
