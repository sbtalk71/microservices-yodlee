package com.demo.spring;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hr")
public class HrResourceController {

	@Autowired
	private RestTemplate rt;

	@GetMapping(path = "/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmpDetails(@RequestParam("eid") int id) {
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity req = new HttpEntity(headers);

		ResponseEntity<String> resp = rt.exchange("http://empdata.com/emp/find/"+id, HttpMethod.GET, req, String.class);
		
		System.out.println(rt.getClass().getName());
		return resp;
	}
	@PostMapping(path="/register",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> registerEmp(
			@RequestParam("id")int id, 
			@RequestParam("name")String name,
			@RequestParam("city")String city,
			@RequestParam("salary")double salary){
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		HashMap<String, Object> data=new HashMap<>();
		data.put("empId", id);
		data.put("name", name);
		data.put("city", city);
		data.put("salary", salary);
		
		HttpEntity req = new HttpEntity(data,headers);

		ResponseEntity<String> resp = rt.exchange("http://empdata.com/emp/save", HttpMethod.POST, req, String.class);
		return resp;
	}
}
