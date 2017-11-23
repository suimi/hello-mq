/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.kafka.server.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.MessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import com.suimi.hello.mq.dto.Message;
import com.suimi.hello.mq.dto.OneMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author suimi
 * @date 2017-11-16
 */
@Component
@Slf4j
public class Producer {

    @Autowired
    private KafkaTemplate<String, Message> template;

    @Autowired
    private KafkaTemplate<String, OneMessage> template2;

    @Autowired
    private KafkaTemplate<String, String> template1;

    public void send(String topic, Message message) {
        log.info("send Message {} to {}", message, topic);
        template.send(topic, message);
    }

    public void send(String topic, OneMessage message) {
        log.info("send OneMessage {} to {}", message, topic);
        template2.send(topic, message);
    }

    public void send(String topic, String message) {
        log.info("send message {} to {}", message, topic);
        template1.send(topic, message);
    }

}
