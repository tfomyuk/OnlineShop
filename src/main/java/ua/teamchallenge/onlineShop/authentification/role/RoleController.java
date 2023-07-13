package ua.teamchallenge.onlineShop.authentification.role;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<RoleDto> getRoles() {
        return roleService.findAll();
    }

    @PostMapping("/create")//instead of id we need to put RoleDto obj
    public RoleDto postRole(@ModelAttribute("role") RoleDto roleDto) {
        return roleService.create(roleDto);
    }

    @GetMapping("/delete/{id}")
    public boolean removeRole(@PathVariable("id") UUID roleId) {
        try {
            roleService.delete(roleId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
