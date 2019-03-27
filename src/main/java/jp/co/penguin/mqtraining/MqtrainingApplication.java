package jp.co.penguin.mqtraining;

import com.rabbitmq.client.Command;
import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@Data
@SpringBootApplication
@ConfigurationProperties(prefix = "message-broker")
public class MqtrainingApplication implements CommandLineRunner {

	private String queueName;

	@Autowired
	AnnotationConfigApplicationContext context;

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MqtrainingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Waiting 1 seconds...");
		Thread.sleep(1000);
		System.out.println("Sending message...");

		rabbitTemplate.convertAndSend(queueName, "WRYYYYYYYYYYYY!!!");
		context.close();
	}
}
