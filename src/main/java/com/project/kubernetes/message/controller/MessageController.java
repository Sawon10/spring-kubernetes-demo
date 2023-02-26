package com.project.kubernetes.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.kubernetes.entity.MessageBody;

@RestController
public class MessageController {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka.topic.test.first}")
	private String testTopicKafka;
	
	@RequestMapping(path = "/api/publish/message", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<String> publishMessage(@RequestBody MessageBody messageBody) {
		System.out.println(messageBody.getMessage());
		kafkaTemplate.send(testTopicKafka ,messageBody.getSender() , messageBody.getMessage());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
