package com.suimi.hello.kafka.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.suimi.hello.kafka.server.producer.Producer;
import com.suimi.hello.mq.dto.Message;
import com.suimi.hello.mq.dto.OneMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaServerApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            producer.send("Topic", "test" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void testObject() {
        producer.send("Topic", new Message("hello"));
        producer.send("Topic", new OneMessage("key", "value"));
    }

}
