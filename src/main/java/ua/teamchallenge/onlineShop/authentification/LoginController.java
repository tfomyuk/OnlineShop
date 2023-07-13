package ua.teamchallenge.onlineShop.authentification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @GetMapping
    public String get() {
        LOG.error("Login page start");
        return "Login";
    }
}
