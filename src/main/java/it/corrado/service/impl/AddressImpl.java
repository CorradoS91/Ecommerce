package it.corrado.service.impl;

import it.corrado.dto.AddressDto;
import it.corrado.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class AddressImpl implements AddressService {
    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public Optional<AddressDto> getAddressById(Long addressId) {
        return Optional.empty();
    }

    @Override
    public List<AddressDto> getAddressesByUserId(Long userId) {
        return List.of();
    }

    @Override
    public AddressDto updateAddress(Long addressId, AddressDto AddressDto) {
        return null;
    }

    @Override
    public void deleteAddress(Long addressId) {

    }
}
