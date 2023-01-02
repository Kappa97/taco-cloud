package org.crystal.tacocloud.tacos.security.services;

import org.crystal.tacocloud.tacos.User;
import org.crystal.tacocloud.tacos.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
