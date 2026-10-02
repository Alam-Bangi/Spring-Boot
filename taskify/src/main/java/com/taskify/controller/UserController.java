package com.taskify.controller;

import com.taskify.dto.UserRequest;
import com.taskify.dto.UserUpdateRequest;
import com.taskify.entity.User;
import com.taskify.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping()
    public User createUser(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest);
        User user =  userService.addUser(userRequest);
        return user;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUser();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.updateUser(id, userUpdateRequest);
    }
}
