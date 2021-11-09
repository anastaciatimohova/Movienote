package com.movienote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovienoteApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MovienoteApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //SpringApplication.run(MovienoteApplication.class, args);
    }

}
