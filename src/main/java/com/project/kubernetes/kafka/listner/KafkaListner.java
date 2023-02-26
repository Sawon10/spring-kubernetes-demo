package com.project.kubernetes.kafka.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {
	
	@KafkaListener(topics = "Test-topic", groupId = "local")
	public void listnerTestTopic(String message){
		System.out.println(message);
	}
	
}
