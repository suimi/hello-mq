/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.mq.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author suimi
 * @date 2017-11-15
 */
@Data
public class Message implements Serializable{

    private static final long serialVersionUID = 6941446328215868704L;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    private String message;

    private Date date = new Date();
}
