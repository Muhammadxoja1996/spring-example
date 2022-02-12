package uz.ilmuz.startspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.ilmuz.startspring.dto.user.UserDto;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Muhammadxo'ja
 * Date: 03.02.2022
 * Time: 22:03
 */
@Entity
@Table(name = "user_auth")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_auth_sec")
    @SequenceGenerator(name = "user_auth_sec", sequenceName = "user_auth_sec", allocationSize = 1)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String role;
    private String password;
    @Column(name = "login",unique = true)
    private String login;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "user")
    private List<Item> items;

    public User(UserDto userDto) {
        this.userName = userDto.getUserName();
        this.role = userDto.getRole();
        this.password = userDto.getPassword();
        this.login = userDto.getLogin();
        this.email = userDto.getEmail();
        this.phoneNumber = userDto.getPhoneNumber();
    }

    public User(Long id) {
        this.id = id;
    }

    public void setUser(UserDto userDto){
        this.userName = userDto.getUserName();
        this.role = userDto.getRole();
        this.password = userDto.getPassword();
        this.login = userDto.getLogin();
        this.email = userDto.getEmail();
        this.phoneNumber = userDto.getPhoneNumber();
    }
}
