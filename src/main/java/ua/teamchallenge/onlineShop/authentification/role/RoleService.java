package ua.teamchallenge.onlineShop.authentification.role;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public List<RoleDto> findAll() {
        return repository.findAll()
                .stream()
                .map(RoleConverter::mapToDto)
                .collect(Collectors.toList());
    }

    public RoleDto findById(UUID id) {
        return repository.findById(id)
                .map(RoleConverter::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }

    public RoleDto create(RoleDto roleDto){
        repository.save(RoleConverter.mapToDao(roleDto));
        return roleDto;
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }
}
