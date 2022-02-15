package uz.ilmuz.startspring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ilmuz.startspring.dto.user.UserDto;
import uz.ilmuz.startspring.entity.User;
import uz.ilmuz.startspring.repository.user.UserRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Muhammadxo'ja
 * Date: 03.02.2022
 * Time: 21:31
 */
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

    public UserDto getOne(Long id) {
        return new UserDto(userRepo.findById(id).get());
    }


    public String addUser(UserDto userDto) {
        String result = "ERROR";
        try {
            userRepo.save(new User(userDto));
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

    @Transactional
    public String delete(String login){
        String result = "ERROR";
        try {
            userRepo.deleteByLogin(login);
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
