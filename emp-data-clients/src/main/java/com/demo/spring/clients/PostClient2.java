package com.demo.spring.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class PostClient2 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();

		Emp e = new Emp(111, "Arjun", "Hyderabad", 85000);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_XML_VALUE);

		HttpEntity req = new HttpEntity(e, headers);

		ResponseEntity<String> resp = rt.exchange("http://localhost:8181/emp/save", HttpMethod.POST, req, String.class);
		System.out.println(resp.getBody());

	}

}
