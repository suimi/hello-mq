/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.kafka.server.producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suimi
 * @date 2017-11-16
 */
@RestController

public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/producer")
    public String send() {
        kafkaTemplate.send("my-replicated-topic", "hello kafka 111");
        kafkaTemplate.send("my-replicated-topic", "hello kafka 222");

        kafkaTemplate.metrics();

        kafkaTemplate.execute(producer -> {
            // 这里可以编写kafka原生的api操作
            return null;
        });

        // 消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(String s, Integer integer, String s2, String s3, RecordMetadata recordMetadata) {

            }

            @Override
            public void onError(String s, Integer integer, String s2, String s3, Exception e) {

            }

            @Override
            public boolean isInterestedInSuccess() {
                return false;
            }
        });

        return "success";
    }
}
