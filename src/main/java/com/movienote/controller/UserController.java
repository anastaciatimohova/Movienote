package com.movienote.controller;

import com.movienote.model.User;
import com.movienote.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для сущности User
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {

        return userService.getAll();

    }

    @GetMapping("/{username}")
    public User getUserByName(@PathVariable("username") String username) {

        return userService.getByName(username);

    }

    @PostMapping()
    public void saveUser(@RequestBody User user) {

        userService.save(user);

    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {

        user.setId(id);

        return userService.update(user);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {

        userService.delete(id);

    }
}
