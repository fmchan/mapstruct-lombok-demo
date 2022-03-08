package com.fmchan.mapstructlombokdemo;

import com.fmchan.mapstructlombokdemo.mapper.UserMapper;
import com.fmchan.mapstructlombokdemo.dto.CarDTO;
import com.fmchan.mapstructlombokdemo.dto.UserDto;
import com.fmchan.mapstructlombokdemo.entity.Car;
import com.fmchan.mapstructlombokdemo.entity.User;
import com.fmchan.mapstructlombokdemo.mapper.CarMapper;
import com.fmchan.mapstructlombokdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MapstructLombokDemoApplicationTests {

	@Autowired UserService userService;
	@Autowired
	UserMapper userMapper;
	@Test
	void contextLoads() {
		UserDto userDto = UserDto.builder().age(30).name("fmchan").middleName("ming").surname("chan").build();
		//userService.createUser(userDto);
		User user = userMapper.toUser(userDto);
		System.out.println(user);
	}
	@Test
	void mapCar() {
		Car entity  = new Car();
		entity.setId(1);
		entity.setName("Toyota");

		CarDTO carDto = CarMapper.INSTANCE.carToCarDTO(entity);
		assertEquals(carDto.getId(), entity.getId());
		assertEquals(carDto.getName(), entity.getName());
	}
}
