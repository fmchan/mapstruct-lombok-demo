package com.fmchan.mapstructlombokdemo.mapper;

import com.fmchan.mapstructlombokdemo.dto.AddressDto;
import com.fmchan.mapstructlombokdemo.dto.DeliveryAddressDto;
import com.fmchan.mapstructlombokdemo.dto.SimpleAddressDto;
import com.fmchan.mapstructlombokdemo.entity.Address;
import com.fmchan.mapstructlombokdemo.entity.User;
import com.fmchan.mapstructlombokdemo.repository.UserRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Mapper
public interface AddressMapper {

    SimpleAddressDto toSimpleAddressDto(Address address);

    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    @Mapping(source = "addressList", target = "deliveryAddressList")
    DeliveryAddressDto toDeliveryAddressDto(User user, List<Address> addressList);

    default DeliveryAddressDto toDeliveryAddressDto(List<Address> addressList) {
        if (!addressList.isEmpty())
            return toDeliveryAddressDto(addressList.get(0).getUser(), addressList);
        return new DeliveryAddressDto();
    }

    @Mapping(source = "userId", target = "user")
    Address toAddress(AddressDto addressDto, @Context UserRepository repo);

    default User getUser(String userId, @Context UserRepository repo) {
        return repo.findById(UUID.fromString(userId)).orElseThrow(NoSuchElementException::new);
    }

    default String map(UUID value) {
        return value.toString();
    }
}
