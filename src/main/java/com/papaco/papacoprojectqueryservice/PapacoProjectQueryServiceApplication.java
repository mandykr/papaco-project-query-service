package com.papaco.papacoprojectqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class PapacoProjectQueryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PapacoProjectQueryServiceApplication.class, args);
    }

}
