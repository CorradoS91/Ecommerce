package it.corrado.service.impl;

import it.corrado.dto.UserDto;
import it.corrado.exception.EmailNotFoundException;
import it.corrado.mapper.UserMapper;
import it.corrado.model.User;
import it.corrado.repository.UserRepository;
import it.corrado.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        Optional<User> userOpt= userRepository.getUserByEmail(user.getEmail());
        if(userOpt.isPresent()){
            throw new EmailNotFoundException(user.getEmail(),"This email already exists: "+user.getEmail());
        }else{
            userRepository.save(user);
            return userMapper.userToUserDto(user);
        }

    }

    @Override
    public UserDto updateUser(UserDto userDto, String email) {
        User oldUser=userRepository.getUserByEmail(email).orElseThrow(()->buildEmailNotFoundException(email));
        userMapper.updateUser(userDto, oldUser);
        userRepository.save(oldUser);
        return userMapper.userToUserDto(oldUser);
    }



    @Override
    public void deleteUser(String email) {
        userRepository.getUserByEmail(email).orElseThrow(()->buildEmailNotFoundException(email));
        userRepository.deleteUserByEmail(email);
    }
    private RuntimeException buildEmailNotFoundException(String email) {
        EmailNotFoundException exception = new EmailNotFoundException();
        exception.setEmailNotFound(email);
        if (email != null) {
            String ms = "The following Email was not found: %s";
            exception.setMessage(String.format(ms, email));
            return exception;
        }
        return null;
    }


}
