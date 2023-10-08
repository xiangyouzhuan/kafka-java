package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

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
		int lingerMs = Integer.parseInt(props.getProperty("linger.ms"));
		String keySerializer = props.getProperty("key.serializer");
		String valueSerializer = props.getProperty("value.serializer");
		String topic = props.getProperty("topic");

		props.put("bootstrap.servers", bootstrapServers);
		props.put("linger.ms", lingerMs);
		props.put("key.serializer", keySerializer);
		props.put("value.serializer", valueSerializer);

		Producer<String, String> producer = new KafkaProducer<>(props);
		while (true){
			Scanner scanner = new Scanner(System.in);
			String a = scanner.next();
			System.out.printf("发送消息: %s 到%s\n",a,topic);
			producer.send(new ProducerRecord<String, String>(topic, a));
		}
		//		producer.close();
	}

}
