package com.demo.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:messages.properties")
public class TestResource {

	@Value("${greet.message: no message Found}")
	private String msg;
	
	@RequestMapping(path="/greet",method = RequestMethod.GET)
	public String greet() {
		return msg;
	}
}
