package ua.teamchallenge.onlineShop.authentification;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.teamchallenge.onlineShop.authentification.role.RoleDto;
import ua.teamchallenge.onlineShop.authentification.role.RoleService;
import ua.teamchallenge.onlineShop.authentification.user.UserDto;
import ua.teamchallenge.onlineShop.authentification.user.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping({"/","/index"})
public class MainController {
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping
    public String get() {
        LOG.error("Main page start");
        return "Main page. Type '/users' or '/roles'";
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        LOG.error("Main page start");
        return userService.findAll();
    }

    @GetMapping("/roles")
    public List<RoleDto> getRoles() {
        LOG.error("Main page start");
        return roleService.findAll();
    }
}
