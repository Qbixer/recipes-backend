package com.rysiki.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping("/")
@RestController
public class RecipesApplication {

    @GetMapping("")
    String helloWorld() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }

}
