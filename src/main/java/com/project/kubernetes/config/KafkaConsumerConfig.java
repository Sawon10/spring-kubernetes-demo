package com.project.kubernetes.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.project.kubernetes.entity.MessageBody;

import jakarta.annotation.PostConstruct;


@Configuration
public class KafkaConsumerConfig {
	
	private static Logger LOGGER = LogManager.getLogger(KafkaConsumerConfig.class);
	
	@PostConstruct
	public void init() {
		LOGGER.info("Initiated the kafkaConsumer Config, Server is {}",bootStrapServer);
	}
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootStrapServer;
	
	@Bean
	public Map<String, Object> consumerConfig() {
		Map<String, Object> properties = new HashMap<>();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return properties;
	}
	
	@Bean
	public ConsumerFactory<String, MessageBody> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfig());
	}
	
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, MessageBody>> listnerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, MessageBody> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
