package it.corrado.service.impl;

import it.corrado.dto.UserAddressDto;
import it.corrado.dto.UserDto;
import it.corrado.exception.EmailFoundException;
import it.corrado.exception.IdNotFoundException;
import it.corrado.mapper.UserAddressMapper;
import it.corrado.model.Address;
import it.corrado.model.User;
import it.corrado.model.UserAddress;
import it.corrado.repository.AddressRepository;
import it.corrado.repository.UserAddressRepository;
import it.corrado.repository.UserRepository;
import it.corrado.service.UserAddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private final UserAddressRepository userAddressRepository;

    @Autowired
    private final UserAddressMapper userAddressMapper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AddressRepository addressRepository;

    public List<UserAddressDto> getAllUserAddresses(UserDto userDto) {
        User user = userRepository.getUserByEmail(userDto.getEmail())
                .orElseThrow(() -> buildEmailNotFoundException(userDto.getEmail()));

        List<UserAddress> userAddresses = userAddressRepository.findByUser(user);

        return userAddresses.stream()
                .map(userAddressMapper::userAddressToUserAddressDto)
                .collect(Collectors.toList());
    }

    public Optional<UserAddressDto> getUserAddressById(Long id) {
        UserAddress userAddress = userAddressRepository.findById(id)
                .orElseThrow(() -> buildIdNotFoundException(id));
        return Optional.of(userAddressMapper.userAddressToUserAddressDto(userAddress));
    }

    @Override
    public UserAddressDto createUserAddress(UserAddressDto UserAddressDto) {
        return null;
    }

    public UserAddressDto updateUserAddress(Long id, UserAddressDto newUserAddressDto) {
        return userAddressRepository.findById(id).map(existingUserAddress -> {
            existingUserAddress.setIsPrimary(newUserAddressDto.getIsPrimary());

            // Se necessario, aggiorna user e address a partire dagli ID presenti nel DTO
            User user = userRepository.findById(newUserAddressDto.getUserAddressId())
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + newUserAddressDto.getUserAddressId()));
            existingUserAddress.setUser(user);

            Address address = addressRepository.findById(newUserAddressDto.getAddress().getAddressId())
                    .orElseThrow(() -> new RuntimeException("Address not found with ID: " + newUserAddressDto.getAddress().getAddressId()));
            existingUserAddress.setAddress(address);

            UserAddress savedUserAddress = userAddressRepository.save(existingUserAddress);
            return userAddressMapper.userAddressToUserAddressDto(savedUserAddress); // Converti in DTO prima di restituire
        }).orElseThrow(() -> buildIdNotFoundException(id));
    }

    public void deleteUserAddress(Long id) {
        userAddressRepository.deleteById(id);
    }
    private RuntimeException buildIdNotFoundException(Long id) {
        IdNotFoundException exception = new IdNotFoundException();
        exception.setIdNotFound(id);
        if (id != null) {
            String ms = "The following Id was not found: %d";
            exception.setMessage(String.format(ms, id));
            return exception;
        }
        return null;
    }

    private RuntimeException buildEmailNotFoundException(String email) {
        EmailFoundException exception = new EmailFoundException();
        exception.setEmailNotFound(email);
        if (email != null) {
            String ms = "The following Email was not found: %s";
            exception.setMessage(String.format(ms, email));
            return exception;
        }
        return null;
    }
}

