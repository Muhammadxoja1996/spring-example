package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDto> allUsers() {
        return entityToDto(userRepo.findAll());
    }


    private List<UserDto> entityToDto(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users) {
            userDtos.add(new UserDto(user));
        }
        return userDtos;
    }
    public String addUser(User userDto) {
        String result = "ERROR";
        try {

            userRepo.save(userDto);
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }


    public String update(UserDto userDto){
        String result = "ERROR";
        try {
            User user = userRepo.findByLogin(userDto.getLogin());
            user.setUser(userDto);
            userRepo.save(user);
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public String delete(String login){
        String result = "ERROR";
        try {
            User user = userRepo.findByLogin(login);
            userRepo.delete(user);
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
