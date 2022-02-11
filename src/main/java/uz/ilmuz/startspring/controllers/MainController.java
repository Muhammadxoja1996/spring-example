package uz.ilmuz.startspring.controllers;

import org.springframework.web.bind.annotation.*;
import uz.ilmuz.startspring.dto.user.UserDto;
import uz.ilmuz.startspring.service.MainService;

import java.util.List;

/**
 * Author: Muhammadxo'ja
 * Date: 03.02.2022
 * Time: 21:29
 */
@RestController
@RequestMapping("/api/v1/user")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/get-all")
    public List<UserDto> allUsers() {
        return mainService.allUsers();
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
