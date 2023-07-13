package ua.teamchallenge.onlineShop.authentification.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.teamchallenge.onlineShop.authentification.role.Role;

import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "login"})
@ToString(of = {"id", "login"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @Getter
    private UUID id;

    @Getter
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Getter
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public List<Role> getUserRoles() {
        return Collections.unmodifiableList(roles);
    }

    public void addUserRole(Role roleDao) {
        roles.add(roleDao);
    }

    public void removeUserRole(Role roleDao) {
        roles.remove(roleDao);
    }

}
