package com.maotion.micronasdaq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicronasdaqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicronasdaqApplication.class, args);
    }

}
