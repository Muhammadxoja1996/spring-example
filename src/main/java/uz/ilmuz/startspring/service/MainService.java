package uz.ilmuz.startspring.service;

import org.springframework.stereotype.Service;
import uz.ilmuz.startspring.dto.user.UserDto;
import uz.ilmuz.startspring.entity.User;
import uz.ilmuz.startspring.repository.user.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    public final UserRepo userRepo;

    public MainService(UserRepo userRepo) {
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
        UserDto userDto = new UserDto(userRepo.findById(id).get());
        return userDto;
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
