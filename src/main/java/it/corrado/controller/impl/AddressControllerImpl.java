package it.corrado.controller.impl;

import it.corrado.controller.AddressController;
import it.corrado.dto.AddressDto;
import it.corrado.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController {

    @Autowired
    private final AddressService addressService;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        return addressService.createAddress(addressDto);
    }

    @Override
    public Optional<AddressDto> getAddressById(Long addressId) {
        return addressService.getAddressById(addressId);
    }

    @Override
    public List<AddressDto> getAddressesByUserId(Long userId) {
        return addressService.getAddressesByUserId(userId);
    }

    @Override
    public AddressDto updateAddress(Long addressId, AddressDto AddressDto) {
        return addressService.updateAddress(addressId, AddressDto);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressService.deleteAddress(addressId);
    }
}
