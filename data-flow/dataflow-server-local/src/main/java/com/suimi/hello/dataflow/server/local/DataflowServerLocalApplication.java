package com.suimi.hello.dataflow.server.local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@SpringBootApplication
@EnableDataFlowServer
public class DataflowServerLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataflowServerLocalApplication.class, args);
    }
}
