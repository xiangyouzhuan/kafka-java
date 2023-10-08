package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.printf("hello");
		Properties props = new Properties();
		File file = new File("src/main/resources/application.properties");
		try (InputStream in = new FileInputStream(file)) {
			props.load(in);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		String bootstrapServers = props.getProperty("bootstrap.servers");
		String groupId = props.getProperty("group.id");
		String enableAutoCommit = props.getProperty("enable.auto.commit");
		String autoCommitIntervalMs = props.getProperty("auto.commit.interval.ms");
		String keyDeserializer = props.getProperty("key.deserializer");
		String valueDeserializer = props.getProperty("value.deserializer");
		String topic = props.getProperty("topic");

		props.setProperty("bootstrap.servers", bootstrapServers);
		props.setProperty("group.id", groupId);
		props.setProperty("enable.auto.commit", enableAutoCommit);
		props.setProperty("auto.commit.interval.ms", autoCommitIntervalMs);
		props.setProperty("key.deserializer", keyDeserializer);
		props.setProperty("value.deserializer", valueDeserializer);
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("my-topic"));
		System.out.println( "Receiving!..." );

		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

			for (ConsumerRecord<String, String> record : records){
				System.out.printf("收到订阅的topic:%s发送的消息%s\n",topic,record.value());
			}
		}
//		SpringApplication.run(DemoApplication.class, args);

	}

}
