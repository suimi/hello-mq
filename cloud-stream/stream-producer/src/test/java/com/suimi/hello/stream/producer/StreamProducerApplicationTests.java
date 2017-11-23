package com.suimi.hello.stream.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.suimi.hello.mq.dto.Message;
import com.suimi.hello.mq.dto.OneMessage;
import com.suimi.hello.stream.producer.service.SendService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("kafka")
@ActiveProfiles("rabbitmq")
public class StreamProducerApplicationTests {

    @Autowired
    private SendService sendService;

    @Test
    public void test() {
//        sendService.sendMessage(new Message("hello stream"));
//        sendService.sendMessage(new OneMessage("key", "value"));

//        sendService.sendAllMessage(new Message("hello stream"));
        for (int i = 0; i < 100; i++) {
            sendService.sendAllMessage(new OneMessage(""+i, "value1"));
            sendService.sendAllMessage(new OneMessage(""+i, "value2"));
            sendService.sendAllMessage(new OneMessage(""+i, "value3"));
        }
    }

}
