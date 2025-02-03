package it.corrado.mapper;

import it.corrado.dto.AddressDto;
import it.corrado.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface AddressMapper {

    AddressDto addressToAddressDto(AddressDto addressDto);

    Address addressDtoToAddress(Address address);

    void updateAddress(AddressDto addressDto, @MappingTarget Address address);

}
