package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private JsonPlaceHolderClient client;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(client.getPostById(70));

	}

}
