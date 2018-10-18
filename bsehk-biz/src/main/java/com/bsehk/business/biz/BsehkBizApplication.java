package com.bsehk.business.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by 24398 on 2018/10/17.
 */
@SpringBootApplication
@ComponentScan({"com.bsehk.business.biz","com.bsehk.business"})
public class BsehkBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(BsehkBizApplication.class, args);
    }

}
