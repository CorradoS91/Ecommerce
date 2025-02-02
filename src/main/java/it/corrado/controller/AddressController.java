package it.corrado.controller;

import it.corrado.dto.AddressDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/address")
public interface AddressController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AddressDto createAddress(@RequestBody AddressDto addressDto);
    @GetMapping("/{addressId}")
    Optional<AddressDto> getAddressById(Long addressId);
    @GetMapping("/{userId}/addresses")
    List<AddressDto> getAddressesByUserId(Long userId);
    @PutMapping("{addressId}")
    @ResponseStatus(HttpStatus.OK)
    AddressDto updateAddress(@PathVariable(name="addressId") Long addressId,@RequestBody AddressDto AddressDto);
    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAddress(@PathVariable(name="id")Long addressId);
}
