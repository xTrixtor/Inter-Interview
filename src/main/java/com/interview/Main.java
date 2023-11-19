package com.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableCaching
@RestController
@RequestMapping("api/v1/users")
public class Main {
    @Autowired
    TestService testService;
    private final UserRepository userRepository;

    public Main(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public List<User> greet()
    {
        return userRepository.findAll();
    }

    @PostMapping
    public boolean CreateUser(@RequestBody User newUser){
        userRepository.saveAndFlush(newUser);
        return true;
    }

    @DeleteMapping
    public void DeleteUserByID(@RequestParam("userId") Integer UserId){
        userRepository.deleteById(UserId);
    }

    @PutMapping
    public User UpdateUser(@RequestBody UserUDto userUDto){
        User dbUser = userRepository.findById(userUDto.userId).get();
        dbUser.setName(userUDto.name);
        userRepository.saveAndFlush(dbUser);
        return dbUser;
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
    public record UserUDto(Integer userId, String name, String email){}
}
