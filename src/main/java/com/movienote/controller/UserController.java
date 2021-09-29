package com.movienote.controller;

import com.movienote.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/all")
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        return users;
    }

    @GetMapping("/username")
    public User getUserByName(@RequestParam(value = "username", required = false) String username) {

        User user = new User();

        return user;

    }

    @PostMapping("/save")
    public void saveUser(@RequestParam(value = "username", required = false) String username,
                         @RequestParam(value = "password", required = false) String password,
                         @RequestParam(value = "email", required = false) String email, User user) {

    }

    @PutMapping("/update")
    public User updateUsernameById(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam(value = "username", required = false) String username) {

        User user = new User();

        return user;
    }

    @DeleteMapping("/delete")
    public List<User> deleteById(@RequestParam(value = "id", required = false) Long id) {

        return getAllUsers();
    }
}
