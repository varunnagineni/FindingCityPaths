package com.mc.find.city.paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
@Configuration
public class FindCityPathsRestApplication {
    private static final Logger log = LoggerFactory.getLogger(FindCityPathsRestApplication.class);

    @PostConstruct
    public void start() {
        log.info("Starting up ....");
    }

    @PreDestroy
    public void tearDown() {
        log.info("Shutting down ....");
    }

    public static void main(String[] args) {
        SpringApplication.run(FindCityPathsRestApplication.class, args);
    }
}
