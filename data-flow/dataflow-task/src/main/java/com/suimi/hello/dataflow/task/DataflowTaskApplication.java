package com.suimi.hello.dataflow.task;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
@EnableBatchProcessing
public class DataflowTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataflowTaskApplication.class, args);
	}
}
