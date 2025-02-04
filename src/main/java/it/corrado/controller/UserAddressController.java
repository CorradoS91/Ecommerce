package it.corrado.controller;

import it.corrado.dto.AddressDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/assign-address")

public interface UserAddressController {

    @PostMapping("/assign")

    void assignAddressToUser(@RequestParam Long userId, @RequestBody AddressDto addressDto);

}

