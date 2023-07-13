package ua.teamchallenge.onlineShop.authentification.role;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class  RoleConverter {
    public static RoleDto mapToDto(Role roleDao) {
        return new RoleDto(
                roleDao.getId(),
                roleDao.getName()
        );
    }

    public static Role mapToDao(RoleDto roleDto){
        return new Role(
                roleDto.getId(),
                roleDto.getName()
        );
    }

    public static List<Role> mapToDaoList(List<RoleDto> roleDtoList){
        return roleDtoList.stream()
                .map(RoleConverter::mapToDao)
                .collect(Collectors.toList());
    }

    public static List<RoleDto> mapToDtoList(List<Role> roleDaoList){
        return roleDaoList.stream()
                .map(RoleConverter::mapToDto)
                .collect(Collectors.toList());
    }
}
