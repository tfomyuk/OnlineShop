package ua.teamchallenge.onlineShop.authentification.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.teamchallenge.onlineShop.authentification.user.User;
import ua.teamchallenge.onlineShop.authentification.user.UserDto;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private UUID id;
    private String name;
    //private List<User> users;
}
