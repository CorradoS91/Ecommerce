package it.corrado.service;

import it.corrado.dto.AddressDto;
import it.corrado.dto.UserAddressDto;
import it.corrado.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserAddressService {

    List<UserAddressDto> getAllUserAddresses(UserDto userDto);

    Optional<UserAddressDto> getUserAddressById(Long id);

    UserAddressDto updateUserAddress(Long id, UserAddressDto UserAddressDto);

    void deleteUserAddress(Long id);

    void assignAddressToUser(Long userId, AddressDto addressDto);

    void setPrimaryAddress(Long userId,AddressDto addressDto);
}
