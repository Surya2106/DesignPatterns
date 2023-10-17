package com.example.designpatterns.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookMyShowApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookMyShowApplication.class, args);

    }

}
