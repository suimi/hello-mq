/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.stream.consumer.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ChannelDefine {

    String in = "in";

    String all = "all";


    @Input(ChannelDefine.in)
    SubscribableChannel in();

    @Input(ChannelDefine.all)
    SubscribableChannel all();
}
