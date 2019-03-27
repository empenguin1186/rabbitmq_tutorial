package jp.co.penguin.mqtraining;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Getter
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Recieved <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return this.latch;
    }
}
