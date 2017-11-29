/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.stream.consumer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import com.suimi.hello.mq.dto.Message;
import com.suimi.hello.mq.dto.OneMessage;
import com.suimi.hello.stream.consumer.config.ChannelDefine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author suimi
 * @date 2017-11-20
 */
@EnableBinding(ChannelDefine.class)
@Slf4j
public class ReceiveService {

 /*   @ServiceActivator(inputChannel = ChannelDefine.in)
    public void logMessage(@Payload Object payload, @Headers Map hearders) {
        if (log.isDebugEnabled()) {
            log.debug("log payload：{}, hearders:{}", payload, hearders);
        }
    }

    @Transformer
    public String loggerSink(String payload) {
        if (log.isDebugEnabled()) {
            log.debug("Transformer payload：{}", payload);
        }
        return payload;
    }*/

    @StreamListener(target = ChannelDefine.in, condition = "headers['contentType']=='application/x-java-object;type=com.suimi.hello.mq.dto.Message'")
    public void receiveMessage(@Payload Message message) {
        if (log.isDebugEnabled()) {
            log.debug("received message：{}", message);
        }
    }

    @StreamListener(target = ChannelDefine.in, condition = "headers['contentType']=='application/x-java-object;type=com.suimi.hello.mq.dto.OneMessage'")
    public void receiveMessage(@Payload OneMessage message) {
        if (log.isDebugEnabled()) {
            log.debug("received OneMessage：{}", message);
        }
    }

    @StreamListener(target = ChannelDefine.all)
    public void allMessage(@Payload Object message) {
        if (log.isDebugEnabled()) {
            log.debug("received all message：{}", message);
        }
    }
}
