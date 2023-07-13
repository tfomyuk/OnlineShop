package ua.teamchallenge.onlineShop.authentification.user;

import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.authentification.role.RoleConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserConverter {
    public static UserDto mapToDto(User userDao) {
        return new UserDto(
                userDao.getId(),
                userDao.getLogin(),
                userDao.getPassword(),
                RoleConverter.mapToDtoList(userDao.getUserRoles())
        );
    }

    public static User mapToDao(UserDto userDto){
        return new User(userDto.getId(),
                        userDto.getLogin(),
                        userDto.getPassword(),
                        RoleConverter.mapToDaoList(userDto.getRoles())
        );
    }

    public static List<User> mapToDaoList(List<UserDto> roleDtoList){
        return roleDtoList.stream()
                .map(UserConverter::mapToDao)
                .collect(Collectors.toList());
    }

    public static List<UserDto> mapToDtoList(List<User> roleDaoList){
        return roleDaoList.stream()
                .map(UserConverter::mapToDto)
                .collect(Collectors.toList());
    }
}
