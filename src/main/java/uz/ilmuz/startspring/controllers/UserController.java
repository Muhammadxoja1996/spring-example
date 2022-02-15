package uz.ilmuz.startspring.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ilmuz.startspring.dto.user.UserDto;
import uz.ilmuz.startspring.service.CheckUser;
import uz.ilmuz.startspring.service.UserService;

import java.util.List;

/**
 * Author: Muhammadxo'ja
 * Date: 03.02.2022
 * Time: 21:29
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService mainService;
    private final CheckUser checkUser;

    public UserController(UserService mainService, CheckUser checkUser) {
        this.mainService = mainService;
        this.checkUser = checkUser;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> allUsers() {
        if (checkUser.userCheck()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(mainService.allUsers());
    }

    @GetMapping("/get/{id}")
    public UserDto getOne(@PathVariable Long id) {
        return mainService.getOne(id);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserDto userDto) {
        return mainService.addUser(userDto);
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody UserDto userDto) {
        return mainService.update(userDto);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String login) {
        return mainService.delete(login);
    }
}
