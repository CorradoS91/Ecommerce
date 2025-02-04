package it.corrado.controller.impl;

import it.corrado.controller.UserAddressController;
import it.corrado.dto.AddressDto;
import it.corrado.service.UserAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class UserAddressImpl implements UserAddressController {

    @Autowired
    private final UserAddressService userAddressService;

    @Override
    public void assignAddressToUser(Long userId, AddressDto addressDto) {
        userAddressService.assignAddressToUser(userId,addressDto);
    }
}
