package ua.teamchallenge.onlineShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegisterController {

    @GetMapping
    public String get() {
        return "Registration";
    }
}
