package com.interview.Endpoints;

import com.interview.Models.Dto.UserUDto;
import com.interview.Models.Db.User;
import com.interview.DbRepositories.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping()
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
        User dbUser = userRepository.findById(userUDto.userId()).get();
        dbUser.setName(userUDto.name());
        userRepository.saveAndFlush(dbUser);
        return dbUser;
    }

}
