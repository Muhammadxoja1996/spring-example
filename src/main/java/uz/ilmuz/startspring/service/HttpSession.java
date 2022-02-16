package uz.ilmuz.startspring.service;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Author: Muhammadxo'ja
 * Date: 14.02.2022
 * Time: 21:14
 */

@Data
@Component
@SessionScope
public class HttpSession {
    private String login;
}
