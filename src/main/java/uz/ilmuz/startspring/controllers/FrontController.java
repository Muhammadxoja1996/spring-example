package uz.ilmuz.startspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Muhammadxo'ja
 * Date: 14.02.2022
 * Time: 21:55
 */
@Controller
public class FrontController {

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("text","hello");
        return "index";
    }
}
