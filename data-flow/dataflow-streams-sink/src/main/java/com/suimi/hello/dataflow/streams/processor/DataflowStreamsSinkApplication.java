/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.dataflow.streams.processor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suimi
 * @date 2017-11-28
 */
@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class DataflowStreamsSinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataflowStreamsSinkApplication.class, args);
    }

    @MessageEndpoint

    public static class LoggingMessageEndpoint

    {
        @ServiceActivator(inputChannel = Sink.INPUT)
        public void logIncomingMessages(@Payload String msg, @Headers Map<String, Object> headers) {
            if (log.isDebugEnabled()) {
                log.debug("======================sink========================== {}", msg);
                headers.entrySet().forEach(e -> log.debug("{}:{}", e.getKey() , e.getValue()));
            }
        }
    }

    @StreamListener(Sink.INPUT)
    public void loggerSink(String date) {
        if (log.isDebugEnabled()) {
            log.debug("sink received:{}",date);
        }
    }
}
