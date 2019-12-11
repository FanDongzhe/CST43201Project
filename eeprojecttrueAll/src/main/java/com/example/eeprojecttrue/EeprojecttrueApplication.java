package com.example.eeprojecttrue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableTransactionManagement

public class EeprojecttrueApplication {

    public static void main(String[] args) {
        SpringApplication.run(EeprojecttrueApplication.class, args);
    }

}
