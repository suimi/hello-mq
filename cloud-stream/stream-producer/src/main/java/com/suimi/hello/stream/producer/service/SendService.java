/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.stream.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.suimi.hello.mq.dto.Message;
import com.suimi.hello.mq.dto.OneMessage;
import com.suimi.hello.stream.producer.config.ChannelDefine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author suimi
 * @date 2017-11-20
 */
@EnableBinding(ChannelDefine.class)
@Slf4j
public class SendService {

    @Autowired
    @Qualifier(ChannelDefine.out)
    private MessageChannel outChannel;

    @Autowired
    @Qualifier(ChannelDefine.all)
    private MessageChannel allChannel;

    public void sendMessage(Object message) {
        if (log.isDebugEnabled()) {
            log.debug("send Message：{}", message);
        }
        outChannel.send(MessageBuilder.withPayload(message).setHeader("type",message.getClass().getTypeName()).build());
    }

    public void sendAllMessage(Object message) {
        if (log.isDebugEnabled()) {
            log.debug("send Message：{}", message);
        }
        allChannel.send(MessageBuilder.withPayload(message).setHeader("type",message.getClass().getTypeName()).build());
    }

}
