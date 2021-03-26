package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageSenderController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/kafka/send/{msg}")
	public String sendToKafka(@PathVariable("msg") String message) {
		kafkaTemplate.send("demo-topic",message);
		return "message Sent";
	}
}
