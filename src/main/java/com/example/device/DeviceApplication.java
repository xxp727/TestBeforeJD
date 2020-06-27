package com.example.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceApplication.class, args);
    }

}
