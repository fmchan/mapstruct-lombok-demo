package com.fmchan.mapstructlombokdemo.dto;

import lombok.Data;

@Data
public class SimpleAddressDto {

    private String street;
    private String houseNumber;
    private String postcode;
    private String cityName;
    private String country;

}
