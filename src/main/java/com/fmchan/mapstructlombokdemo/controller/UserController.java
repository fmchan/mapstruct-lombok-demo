package com.fmchan.mapstructlombokdemo.controller;

import com.fmchan.mapstructlombokdemo.dto.AddressDto;
import com.fmchan.mapstructlombokdemo.dto.DeliveryAddressDto;
import com.fmchan.mapstructlombokdemo.dto.UserDto;
import com.fmchan.mapstructlombokdemo.dto.UserInfoDto;
import com.fmchan.mapstructlombokdemo.enumeration.AddressType;
import com.fmchan.mapstructlombokdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PostMapping("/address")
    public ResponseEntity<UserInfoDto> addAddress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(userService.addAddress(addressDto));
    }

    @GetMapping("/{userId}/address")
    public ResponseEntity<DeliveryAddressDto> getDeliveryAddress(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getDeliveryAddress(userId, AddressType.DELIVERY_ADDRESS));
    }

}
