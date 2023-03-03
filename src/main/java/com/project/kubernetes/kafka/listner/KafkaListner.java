package com.project.kubernetes.kafka.listner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {
	
	private static Logger LOGGER = LogManager.getLogger("KafkaListner");
	@KafkaListener(topics = "Test-topic", groupId = "local")
	public void listnerTestTopic(String message){
		LOGGER.info("The message is : {}"+ message);
		System.out.println(message);
	}
	
}
