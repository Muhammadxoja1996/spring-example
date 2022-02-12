package uz.ilmuz.startspring.dto.user;

import lombok.Data;
import uz.ilmuz.startspring.entity.Item;
import uz.ilmuz.startspring.entity.User;

import java.util.List;

@Data
public class UserDto {
    private String userName;
    private String role;
    private String password;
    private String login;
    private String email;
    private String phoneNumber;
    private List<Item> items;

    public UserDto(User user) {
        this.userName = user.getUserName();
        this.role = user.getRole();
        this.password = user.getPassword();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.items = user.getItems();
    }

    public UserDto() {
    }
}
