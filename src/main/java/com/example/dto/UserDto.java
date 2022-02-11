package com.example.dto;

import com.example.entity.Item;
import com.example.entity.User;
import lombok.Data;
import java.util.List;

@Data
public class UserDto {
    private String userName;
    private String login;
    private String password;
    private String userPhone;
    private List<Item> items;

    public UserDto(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.login = user.getLogin();
        this.userPhone = user.getUserPhone();
        this.items = user.getItems();
    }

    public UserDto() {
    }
}
