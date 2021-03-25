package com.demo.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.spring.entity.Post;

@FeignClient(url = "https://jsonplaceholder.typicode.com/",name="myclient")
public interface JsonPlaceHolderClient {

	@GetMapping(path="/posts/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Post getPostById(@PathVariable("id")int id);
}
