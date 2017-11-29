/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.kafka.server.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.suimi.hello.mq.dto.Message;

/**
 * @author suimi
 * @date 2017-11-16
 */
//@Configuration
public class KafkaProducerConfig {

    private final KafkaProperties properties;

    public KafkaProducerConfig(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public KafkaTemplate<?, ?> kafkaTemplate(ProducerListener<Object, Object> kafkaProducerListener) {
        DefaultKafkaProducerFactory<Object, Object> producerFactory = new DefaultKafkaProducerFactory<Object, Object>(
                this.properties.buildProducerProperties());
        KafkaTemplate<Object, Object> kafkaTemplate = new KafkaTemplate<Object, Object>(producerFactory);

        kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());
        kafkaTemplate.setProducerListener(kafkaProducerListener);
        kafkaTemplate.setDefaultTopic(this.properties.getTemplate().getDefaultTopic());
        return kafkaTemplate;
    }
}
