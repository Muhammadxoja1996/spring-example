package com.example.controllers;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all")
    public List<UserDto> allUsers() {
        return userService.allUsers();
    }

//    @GetMapping("/get/{id}")
//    public UserDto getOne(@PathVariable("id") Long id) {
//        return mainService.getOne(id);
//    }

    @PostMapping("/add")
    public String addUser(@RequestBody User userDto) {
        return userService.addUser(userDto);
    }
    @PostMapping("/add/item")
    public String addItem(@RequestBody User userDto) {
        return userService.addUser(userDto);
    }
}


