package it.corrado.mapper;

import it.corrado.dto.UserDto;
import it.corrado.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userToUserDto(UserDto userDto);
}
