package com.franca.hrworker;


import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HrWorkerApplication {

	@Autowired
	private EurekaClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}


}
