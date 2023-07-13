package ua.teamchallenge.onlineShop.authentification.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.teamchallenge.onlineShop.authentification.role.Role;
import ua.teamchallenge.onlineShop.authentification.role.RoleDto;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String login;
    private String password;
    private List<RoleDto> roles;
}
