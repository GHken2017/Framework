package com.microservice.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.ifaces.hw.HwTService;
import com.microservice.ifaces.hw.UserDto;
import com.microservice.service.UserService;
import com.microservice.util.ThriftServiceAnnotation;
/**
 * Hello world!
 *
 */
@ThriftServiceAnnotation
public class UserTServiceHandler implements HwTService.Iface{
	
	@Autowired
	private UserService userService; // 用户Service

	@Override
	public UserDto getUser() {

		UserDto userDto=userService.getUser();
		return userDto;
	}

}
