package ua.teamchallenge.onlineShop.authentification.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true)
public class WebSecurityConfig {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(withDefaults())
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
            .authorizeHttpRequests( req -> req
                    .requestMatchers("/**").permitAll()
                    .anyRequest().authenticated())
            .formLogin(form -> form
                    .usernameParameter("login")
                    .passwordParameter("password")
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/index",true))
            .logout(l-> l.permitAll().deleteCookies());
        return http.build();
    }
}
