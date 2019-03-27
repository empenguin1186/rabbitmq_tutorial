package jp.co.penguin.mqtraining;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

@Data
@SpringBootApplication
@ConfigurationProperties(prefix = "message-broker")
public class ReceiverApplication implements CommandLineRunner {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ReceiverApplication.class, args);
    }

    private String queueName;

    private String topicExchangeName;

    @Autowired
    private Receiver receiver;

    @Autowired
    private AnnotationConfigApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        // 止めるまで待機
    }
}
