package uz.ilmuz.startspring.dto.user;

import lombok.Data;
import uz.ilmuz.startspring.entity.User;

/**
 * Author: Muhammadxo'ja
 * Date: 03.02.2022
 * Time: 22:10
 */
@Data
public class UserDto {
    private String userName;
    private String role;
    private String password;
    private String login;
    private String email;
    private String phoneNumber;

    public UserDto(User user) {
        this.userName = user.getUserName();
        this.role = user.getRole();
        this.password = user.getPassword();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }

    public UserDto() {
    }
}
