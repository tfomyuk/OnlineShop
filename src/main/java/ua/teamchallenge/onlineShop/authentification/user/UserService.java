package ua.teamchallenge.onlineShop.authentification.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<UserDto> findAll(){
        return repository.findAll(Sort.by("login"))
                .stream()
                .map(UserConverter::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto findById(UUID id) {
        return repository.findById(id)
                .map(UserConverter::mapToDto)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserDto findByLogin(String login){
        return repository.findByLogin(login)
                .map(UserConverter::mapToDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public UserDto create(UserDto userDto){
        repository.save(UserConverter.mapToDao(userDto));
        return userDto;
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public void setPassword(UserDto userDto, String password) {
        String passwordHash = passwordEncoder.encode(password);
        userDto.setPassword(passwordHash);
    }
}
