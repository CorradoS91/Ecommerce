package it.corrado.mapper;

import it.corrado.dto.UserAddressDto;
import it.corrado.model.UserAddress;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserAddressMapper {
    UserAddressDto userAddressToUserAddressDto(UserAddress userAddress);
    UserAddress userAddressDtoToUserAddress(UserAddressDto UserAddressDto);
    void updateUserAddress(UserAddressDto UserAddressDto, @MappingTarget UserAddress userAddress);
}
