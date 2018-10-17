package com.bsehk.business.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan({"com.bsehk.business.web","com.bsehk.business.biz","com.bsehk.business"})
public class BsehkWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsehkWebApplication.class, args);
	}
}
