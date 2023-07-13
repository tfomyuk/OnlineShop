package ua.teamchallenge.onlineShop.authentification.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JdbcUserDetails implements UserDetailsService {
    private final UserService service;
    private UserDto user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            user = service.findByLogin(username);
            return new UserDetails() {
                @Override
                public List<SimpleGrantedAuthority> getAuthorities() {
                    return user.getRoles().stream()
                            .map(roleDao ->
                                    new SimpleGrantedAuthority(roleDao.getName()))
                            .collect(Collectors.toList());
                }

                public UUID getId() {
                    return user.getId();
                }

                @Override
                public String getPassword() {
                    return user.getPassword();
                }

                @Override
                public String getUsername() {
                    return user.getLogin();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
        } catch (ResponseStatusException e) {
            throw new UsernameNotFoundException(username);
        }

    }
}
