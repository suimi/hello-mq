/*
 * Copyright (c) 2013-2015,  suimi
 */
package com.suimi.hello.dataflow.shell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.shell.EnableDataFlowShell;

/**
 * @author suimi
 * @date 2017-11-28
 */
@SpringBootApplication
@EnableDataFlowShell
public class DataflowShellApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataflowShellApplication.class, args);
    }
}
