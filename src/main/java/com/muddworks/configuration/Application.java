package com.muddworks.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point into the system.
 * <p>
 * Created on 3/31/17.
 */
@SpringBootApplication(scanBasePackages = "com.muddworks")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
