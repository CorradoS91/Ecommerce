package it.corrado.service;

import it.corrado.dto.UserDto;


public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, String email);
    void deleteUser(String email);
}
