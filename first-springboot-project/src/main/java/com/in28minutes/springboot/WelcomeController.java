package com.in28minutes.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.configuration.BasicConfiguration;

@RestController
public class WelcomeController {
 
	@Autowired
    private WelcomeService service;
	
	@Autowired
	private BasicConfiguration basicConfiguration; 
	
	@RequestMapping("/welcome")
	public String WelcomeMessage()
	{
		return service.RetrieveWelcomeMsg();
	}
	
	@RequestMapping("/dynamic-configuration")
	public Map DynamicConfiguration()
	{
		Map map = new HashMap();
		map.put("message", basicConfiguration.getMessage());
		map.put("number", basicConfiguration.getNumber());
		map.put("value", basicConfiguration.isValue());
		return map;
	}
	
}
