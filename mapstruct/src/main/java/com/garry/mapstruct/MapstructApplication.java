package com.garry.mapstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.garry.mapstruct"})
public class MapstructApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapstructApplication.class, args);
    }

}
