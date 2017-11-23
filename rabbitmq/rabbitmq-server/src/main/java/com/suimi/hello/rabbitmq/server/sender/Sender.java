/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.rabbitmq.server.sender;

import org.slf4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.suimi.hello.mq.dto.Message;
import com.suimi.hello.mq.dto.OneMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author suimi
 * @date 2017-11-15
 */
@Component
@Slf4j
public class Sender {

    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    public void send(String routingKey, Message message) {
        log.info("send message:{} with routing:{}", message, routingKey);
        rabbitMqTemplate.convertAndSend(routingKey, message);
    }

    public void send(String exchange, String routingKey, Message message) {
        message.setMessage(message.getMessage() + " " + exchange + " " + routingKey);
        log.info("send message:{} with exchange:{}, routing:{},", message, exchange, routingKey);
        rabbitMqTemplate.convertAndSend(exchange, routingKey, message);
    }

    public void send(String exchange, String routingKey, OneMessage message) {
        message.setValue(message.getValue() + " " + exchange + " " + routingKey);
        log.info("send message:{} with exchange:{}, routing:{},", message, exchange, routingKey);
        rabbitMqTemplate.convertAndSend(exchange, routingKey, message);
    }

    public void send(String exchange, String routingKey, String message) {
        message = message + " " + exchange + " " + routingKey;
        log.info("send message:{} with exchange:{}, routing:{},", message, exchange, routingKey);
        rabbitMqTemplate.convertAndSend(exchange, routingKey, message);
    }
}
