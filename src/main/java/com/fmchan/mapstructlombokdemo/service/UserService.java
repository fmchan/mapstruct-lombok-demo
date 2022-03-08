package com.fmchan.mapstructlombokdemo.service;

import com.fmchan.mapstructlombokdemo.dto.AddressDto;
import com.fmchan.mapstructlombokdemo.dto.DeliveryAddressDto;
import com.fmchan.mapstructlombokdemo.dto.UserDto;
import com.fmchan.mapstructlombokdemo.dto.UserInfoDto;
import com.fmchan.mapstructlombokdemo.enumeration.AddressType;

public interface UserService {

    UserDto createUser(UserDto userDto);

    DeliveryAddressDto getDeliveryAddress(String userId, AddressType deliveryAddress);

    UserInfoDto addAddress(AddressDto addressDto);
}
