/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.dataflow.streams.processor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suimi
 * @date 2017-11-28
 */
@SpringBootApplication
@EnableBinding(Processor.class)
@Slf4j
public class DataflowStreamsProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataflowStreamsProcessorApplication.class, args);
    }

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Long timestamp) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:yy");
        String date = dateFormat.format(timestamp);
        if (log.isDebugEnabled()) {
            log.debug("======================processor==========================, {}", date);
        }
        return date;
    }

}
