package it.corrado.service;

import it.corrado.dto.AddressDto;
import it.corrado.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);
    Optional<AddressDto> getAddressById(Long addressId);
    List<AddressDto> getAddressesByUserId(Long userId);
    AddressDto updateAddress(Long addressId, AddressDto AddressDto);
    void deleteAddress(Long addressId);
}
