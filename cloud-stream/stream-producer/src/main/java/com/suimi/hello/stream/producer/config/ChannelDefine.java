/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.stream.producer.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ChannelDefine {

    String out = "out";

    String all = "all";

    @Output(ChannelDefine.out)
    MessageChannel out();

    @Output(ChannelDefine.all)
    MessageChannel all();
}
