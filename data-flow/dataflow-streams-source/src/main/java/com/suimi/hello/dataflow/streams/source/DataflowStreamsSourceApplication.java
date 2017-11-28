/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.dataflow.streams.source;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suimi
 * @date 2017-11-28
 */
@SpringBootApplication
@EnableBinding(Source.class)
@Slf4j
public class DataflowStreamsSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataflowStreamsSourceApplication.class, args);
    }

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
    public MessageSource<Long> timeMessageSource() {
        if (log.isDebugEnabled()) {
            log.debug("======================source==========================, {}", new Date());
        }
        return () -> MessageBuilder.withPayload(System.currentTimeMillis()).build();
    }

}
