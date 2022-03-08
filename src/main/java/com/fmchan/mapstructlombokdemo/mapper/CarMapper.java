package com.fmchan.mapstructlombokdemo.mapper;

import com.fmchan.mapstructlombokdemo.dto.CarDTO;
import com.fmchan.mapstructlombokdemo.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CarMapper {
    
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    
    CarDTO carToCarDTO(Car car);
}
