package ua.teamchallenge.onlineShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.teamchallenge.onlineShop.authentification.role.RoleDto;
import ua.teamchallenge.onlineShop.authentification.role.RoleService;
import ua.teamchallenge.onlineShop.authentification.user.UserDto;
import ua.teamchallenge.onlineShop.authentification.user.UserService;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor
//@RestController
@RequestMapping({"/", "/index"})
public class MainController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping
    public String get() {
        return "Main page";
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/roles")
    public List<RoleDto> getRoles() {
        return roleService.findAll();
    }
}
