package com.lizl.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@SpringBootApplication
@EnableEurekaClient
public class EshopProductServiceApplication {

    public static void main(String args[]){
        SpringApplication.run(EshopProductServiceApplication.class, args);
    }
}
