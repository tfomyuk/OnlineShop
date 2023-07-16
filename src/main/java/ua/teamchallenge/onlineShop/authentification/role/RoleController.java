package ua.teamchallenge.onlineShop.authentification.role;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequiredArgsConstructor
//@RestController
@CrossOrigin(
        methods = {POST, GET, OPTIONS, PUT, DELETE, PATCH},
        maxAge = 3600,
        allowedHeaders = {"x-requested-with", "origin", "content-type", "accept"},
        origins = "*"
)
@RequestMapping("api/roles")
@Tag(name = "Roles Service", description="Provide crud operations for Roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<RoleDto> getRoles() {
        return roleService.findAll();
    }

    @PostMapping("/create")
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
