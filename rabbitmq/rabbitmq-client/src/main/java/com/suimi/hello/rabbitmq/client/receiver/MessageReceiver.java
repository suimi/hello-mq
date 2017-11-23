/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.rabbitmq.client.receiver;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
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
@RabbitListener(queues = {"a", "b", "c", "d", "e", "f"})
public class MessageReceiver {

    @RabbitHandler
    public void a(Message hello, @Header(AmqpHeaders.CONSUMER_QUEUE) String queue) {
        if (log.isDebugEnabled()) {
            log.debug("Receiver Message:{} from queue:{}", hello, queue);
        }
    }

        @RabbitHandler
        public void a(OneMessage hello, @Header(AmqpHeaders.CONSUMER_QUEUE) String queue) {
            if (log.isDebugEnabled()) {
                log.debug("Receiver OneMessage:{} from queue:{}", hello, queue);
            }
        }

    @RabbitHandler
    public void a(String hello, @Header(AmqpHeaders.CONSUMER_QUEUE) String queue) {
        if (log.isDebugEnabled()) {
            log.debug("Receiver message:{} from queue:{}", hello, queue);
        }
    }
}
