package it.corrado.repository;

import it.corrado.dto.AddressDto;
import it.corrado.dto.UserDto;
import it.corrado.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface AddressRepository extends JpaRepository<Address, Long> {
    AddressDto getAddressByUser(UserDto userDto);
}