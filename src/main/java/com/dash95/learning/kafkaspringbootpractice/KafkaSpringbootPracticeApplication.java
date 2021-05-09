package com.dash95.learning.kafkaspringbootpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaSpringbootPracticeApplication implements ApplicationRunner {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String msg) {
		kafkaTemplate.send("Hello-Kafka", msg);
	}

	@KafkaListener(topics = "Hello-Kafka", groupId = "group-id")
	public void listen(String message) {
		System.out.println("Received Messasge in group - group-id: " + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringbootPracticeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		sendMessage("Hi Welcome to Spring For Apache Kafka");
	}

}
