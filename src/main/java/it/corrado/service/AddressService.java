package it.corrado.service;

import it.corrado.dto.AddressDto;
import java.util.Optional;
import java.util.Set;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);
    Optional<AddressDto> getAddressById(Long addressId);
    Set<AddressDto> getAddressesByUserId(Long userId);
    AddressDto updateAddress(Long addressId, AddressDto AddressDto);
    void deleteAddress(Long addressId);
}
