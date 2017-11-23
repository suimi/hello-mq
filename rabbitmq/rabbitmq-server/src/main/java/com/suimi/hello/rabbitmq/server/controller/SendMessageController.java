/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.rabbitmq.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suimi.hello.mq.dto.Message;
import com.suimi.hello.rabbitmq.server.sender.Sender;

/**
 * @author suimi
 * @date 2017-11-15
 */
@RestController
public class SendMessageController {

    @Autowired
    private Sender sender;

    @PutMapping("sendMessage")
    public void sendMessage(String routing, String message) {
        sender.send(routing, new Message(message));
    }

    @PutMapping("sendExchangeMessage")
    public void sendMessage(String exchange, String routing, String message) {
        sender.send(exchange, routing, new Message(message));
    }
}
