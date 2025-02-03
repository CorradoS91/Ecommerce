package it.corrado.service;

import it.corrado.dto.UserAddressDto;
import it.corrado.dto.UserDto;
import java.util.List;
import java.util.Optional;

public interface UserAddressService {

    List<UserAddressDto> getAllUserAddresses(UserDto userDto);

    Optional<UserAddressDto> getUserAddressById(Long id);

    UserAddressDto createUserAddress(UserAddressDto UserAddressDto);

    UserAddressDto updateUserAddress(Long id, UserAddressDto UserAddressDto);

    void deleteUserAddress(Long id);

}
