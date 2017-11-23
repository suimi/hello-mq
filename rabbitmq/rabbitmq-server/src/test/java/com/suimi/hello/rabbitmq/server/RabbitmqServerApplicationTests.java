package com.suimi.hello.rabbitmq.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.suimi.hello.mq.dto.Message;
import com.suimi.hello.mq.dto.OneMessage;
import com.suimi.hello.rabbitmq.server.sender.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqServerApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void send() {
//        sender.send("direct", "a", new Message("message"));
//        sender.send("direct", "a", new OneMessage("key","value"));
//        sender.send("direct", "b",  new Message("message"));
//        sender.send("direct", "c",  new Message("message"));
//        sender.send("header", "a",  new Message("message"));
//        sender.send("header", "b",  new Message("message"));
//        sender.send("fanout", "a",  new Message("message"));
//        sender.send("fanout", "b",  new Message("message"));
//        sender.send("fanout", "c",  new Message("message"));
//        sender.send("fanout", "d",  new Message("message"));
//        sender.send("topic", "e.as",  new Message("message"));
        sender.send("topic", "f.a",  new Message("message"));
        sender.send("topic", "f.s.e",  new Message("message"));
        sender.send("topic", "f.s-1",  new Message("message"));
        sender.send("topic", "f.s.e-1",  new Message("message"));
    }

    @Test
    public void sendString() {
        sender.send("direct", "a", "message");
        sender.send("direct", "b",  "message");
        sender.send("direct", "c",  "message");
        sender.send("header", "a",  "message");
        sender.send("header", "b",  "message");
        sender.send("fanout", "a",  "message");
        sender.send("fanout", "b",  "message");
        sender.send("fanout", "c",  "message");
        sender.send("fanout", "d",  "message");
        sender.send("topic", "e.as",  "message");
        sender.send("topic", "f.a",  "message");
        sender.send("topic", "f.s.e",  "message");
    }

}
