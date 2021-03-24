package com.demo.spring.clients;

import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class RestClient1 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();

		String response = rt.getForObject("http://localhost:8181/emp/find/104", String.class);
		System.out.println(response);
		
		Emp emp = rt.getForObject("http://localhost:8181/emp/find/106", Emp.class);
		System.out.println(emp.getName()+" "+emp.getSalary());

	}

}
