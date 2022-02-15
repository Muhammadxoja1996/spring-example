package uz.ilmuz.startspring.service;

import org.springframework.stereotype.Component;

/**
 * Author: Muhammadxo'ja
 * Date: 14.02.2022
 * Time: 21:28
 */
@Component
public class CheckUser {
    private final HttpSession httpSession;

    public CheckUser(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public boolean userCheck(){
        return httpSession.getLogin() == null;
    }
}
