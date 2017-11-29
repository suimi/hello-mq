/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.kafka.client.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
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
//配置收取消息的分区
//@KafkaListener(topicPartitions = {@TopicPartition(topic = "Topic",partitions = {"2","3"})})
@KafkaListener(topics = "Topic")
public class Consumer {

    @KafkaHandler
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        log.info("consumer message:{}",cr.toString());
    }

    @KafkaHandler
    public void listen(String message) throws Exception {
        log.info("consumer String message:{}",message);
    }

    @KafkaHandler
    public void listen(Message message) throws Exception {
        log.info("consumer Message:{}",message);
    }

    @KafkaHandler
    public void listen(OneMessage message) throws Exception {
        log.info("consumer OneMessage:{}",message);
    }
}
