package com.fmchan.mapstructlombokdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String id;
    private String name;
    private String middleName;
    private String surname;
    private Integer age;
}
