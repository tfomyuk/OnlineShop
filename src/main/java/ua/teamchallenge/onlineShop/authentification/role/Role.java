package ua.teamchallenge.onlineShop.authentification.role;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.teamchallenge.onlineShop.authentification.user.User;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@ToString(of = {"id", "name"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @Getter
    private UUID id;

    @Getter
    @Column(name = "name", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "role_id")
    )
    private List<User> users;

    public List<User> getRoleUsers() {
        return Collections.unmodifiableList(users);
    }

    public void addRolesUser(User userDao) {
        users.add(userDao);
    }

    public void removeRolesUser(User userDao) {
        users.remove(userDao);
    }

    public Role(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
