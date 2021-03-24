package com.demo.spring.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class PostClient1 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();

		Emp e= new Emp(109, "Chandra", "Hyderabad", 87000);
		
		ResponseEntity<String> resp= rt.postForEntity("http://localhost:8181/emp/save", e, String.class);
		System.out.println(resp.getBody());

	}

}
