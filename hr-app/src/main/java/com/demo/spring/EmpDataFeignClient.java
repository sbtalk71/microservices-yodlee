package com.demo.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="empdata.com")
public interface EmpDataFeignClient {

	@GetMapping(path = "/emp/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findEmpById(@PathVariable("id") int id);
}
