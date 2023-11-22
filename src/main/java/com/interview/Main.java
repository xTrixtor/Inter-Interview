package com.interview;

import com.interview.Models.Db.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@EnableCaching

public class Main {
    @Autowired
    TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/test")
    public User[] test() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/users/";
        ResponseEntity<User[]> response
                = restTemplate.getForEntity(url, User[].class);
        return response.getBody();
    }

    @GetMapping("/test2")
    public void test2() {
        Random random = new Random();
        testService.getUserStats(random.nextInt(0,2));
    }
}
