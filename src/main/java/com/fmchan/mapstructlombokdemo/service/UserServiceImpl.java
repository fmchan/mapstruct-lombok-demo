package com.fmchan.mapstructlombokdemo.service;

import com.fmchan.mapstructlombokdemo.dto.AddressDto;
import com.fmchan.mapstructlombokdemo.dto.DeliveryAddressDto;
import com.fmchan.mapstructlombokdemo.dto.UserDto;
import com.fmchan.mapstructlombokdemo.dto.UserInfoDto;
import com.fmchan.mapstructlombokdemo.enumeration.AddressType;
import com.fmchan.mapstructlombokdemo.mapper.AddressMapper;
import com.fmchan.mapstructlombokdemo.mapper.UserMapper;
import com.fmchan.mapstructlombokdemo.repository.AddressRepository;
import com.fmchan.mapstructlombokdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        var user = userMapper.toUser(userDto);
        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    @Transactional(readOnly = true)
    public DeliveryAddressDto getDeliveryAddress(String userId, AddressType deliveryAddress) {
        var addressList = addressRepository.findAllByUserIdAndAddressType(UUID.fromString(userId), deliveryAddress);
        return addressMapper.toDeliveryAddressDto(addressList);
    }

    @Override
    @Transactional
    public UserInfoDto addAddress(AddressDto addressDto) {
        var address = addressRepository.save(addressMapper.toAddress(addressDto, userRepository));
        return userMapper.toUserInfoDto(address.getUser(), address);
    }
}
