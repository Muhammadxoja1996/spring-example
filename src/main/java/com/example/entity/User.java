package com.example.entity;

import com.example.dto.ItemDto;
import com.example.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_auth_sec")
    @SequenceGenerator(name = "user_auth_sec", sequenceName = "user_auth_sec", allocationSize = 1)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(name = "user_phone")
    private String userPhone;

    @OneToMany
    @JoinColumn(name = "items", nullable = false)
    private List<Item> items;


    public void setUser(UserDto userDto){
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.login = userDto.getLogin();
        this.userPhone = userDto.getUserPhone();
    }
}
