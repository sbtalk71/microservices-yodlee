package com.demo.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderController {

	@KafkaListener(topics = "demo-topic",groupId = "group1")
	public void listenToMessage(String message) {
		System.out.println("Message : "+message);
	}
}
