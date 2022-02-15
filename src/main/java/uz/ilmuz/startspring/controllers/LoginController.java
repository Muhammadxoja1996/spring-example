package uz.ilmuz.startspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.ilmuz.startspring.service.HttpSession;

/**
 * Author: Muhammadxo'ja
 * Date: 14.02.2022
 * Time: 21:11
 */
@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private final HttpSession httpSession;

    public LoginController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping("/login")
    public void login(@RequestParam String login){
        httpSession.setLogin(login);
    }
}
