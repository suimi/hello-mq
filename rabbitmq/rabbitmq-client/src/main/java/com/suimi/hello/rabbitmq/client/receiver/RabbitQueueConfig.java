/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.rabbitmq.client.receiver;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suimi
 * @date 2017-11-15
 */
@Configuration
public class RabbitQueueConfig {

    @Bean
    public Queue a() {
        return new Queue("a");
    }

    @Bean
    public Queue b() {
        return new Queue("b");
    }

    @Bean
    public Queue c() {
        return new Queue("c");
    }

    @Bean
    public Queue d() {
        return new Queue("d");
    }

    @Bean
    public Queue e() {
        return new Queue("e");
    }

    @Bean
    public Queue f() {
        return new Queue("f");
    }

    /**
     * Direct类型exchange的路由算法是很简单的：要想一个消息能到达这个队列，需要binding key和routing key正好能匹配得上。
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct");
    }

    /**
     * 通过添加属性key-value匹配
     * @return
     */
    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange("header");
    }

    /**
     *  将消息分发到所有的绑定队列，无routingkey的概念
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout");
    }

    /**
     * topic类型的exchange上时不能随意指定routing_key（一定是指由一系列由点号连接单词的字符串，单词可以是任意的，但一般都会与消息或多或少的有些关联）。
     * Routing key的长度不能超过255个字节。
     * *（星号）：可以（只能）匹配一个单词
     * #（井号）：可以匹配多个单词（或者零个）
     * 当一个队列被绑定为binding key为”#”时，它将会接收所有的消息，此时和fanout类型的exchange很像。
     * 当binding key不包含”*”和”#”时，这时候就很像direct类型的exchange
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic");
    }


    @Bean
    public Binding aDirect() {
        return BindingBuilder.bind(a()).to(directExchange()).with("a");
    }

    @Bean
    public Binding bDirect() {
        return BindingBuilder.bind(b()).to(directExchange()).with("b");
    }

    @Bean
    public Binding cDirect() {
        return BindingBuilder.bind(b()).to(directExchange()).with("*");
    }

    @Bean
    public Binding bindingHeader() {
        return BindingBuilder.bind(c()).to(headersExchange()).where("a").exists();
    }

    @Bean
    public Binding bindingHeader1() {
        return BindingBuilder.bind(d()).to(headersExchange()).where("b").exists();
    }

    @Bean
    public Binding bindingFanout() {
        return BindingBuilder.bind(c()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanout1() {
        return BindingBuilder.bind(d()).to(fanoutExchange());
    }


    @Bean
    public Binding bindingTopic() {
        return BindingBuilder.bind(e()).to(topicExchange()).with("e.*");
    }

    @Bean
    public Binding bindingTopic1() {
        return BindingBuilder.bind(f()).to(topicExchange()).with("f.#-1");
    }
}
