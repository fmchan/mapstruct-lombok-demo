package com.fmchan.mapstructlombokdemo.repository;

import com.fmchan.mapstructlombokdemo.entity.Address;
import com.fmchan.mapstructlombokdemo.enumeration.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    List<Address> findAllByUserIdAndAddressType(UUID userId, AddressType addressType);
}
