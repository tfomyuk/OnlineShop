package ua.teamchallenge.onlineShop.authentification.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers(HttpServletRequest request) {
        return userService.findAll();
    }

    @PostMapping("/create")//instead of id we need to put RoleDto obj
    public UserDto postUser(@ModelAttribute("user") UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/delete/{id}")
    public boolean removeUser(@PathVariable("id") UUID userId) {
        try {
            userService.delete(userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
