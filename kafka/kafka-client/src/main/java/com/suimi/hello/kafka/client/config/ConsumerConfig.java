/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.kafka.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.suimi.hello.mq.dto.Message;

/**
 * @author suimi
 * @date 2017-11-17
 */
//@Configuration
public class ConsumerConfig {

    private final KafkaProperties properties;

    public ConsumerConfig(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        DefaultKafkaConsumerFactory<Object, Object> kafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(
                this.properties.buildConsumerProperties());
        kafkaConsumerFactory.setValueDeserializer(new JsonDeserializer(Message.class));
        configurer.configure(factory, kafkaConsumerFactory);
        return factory;
    }
}
