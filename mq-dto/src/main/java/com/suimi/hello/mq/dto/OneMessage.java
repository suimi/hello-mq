/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 */
package com.suimi.hello.mq.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author suimi
 * @date 2017-11-20
 */
@Data
public class OneMessage implements Serializable{

    private static final long serialVersionUID = -7273483425479394541L;

    private String key;

    private String value;

    public OneMessage() {
    }

    public OneMessage(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
