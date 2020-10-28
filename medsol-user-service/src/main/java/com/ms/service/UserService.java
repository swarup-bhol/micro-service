package com.ms.service;

import com.ms.dto.UserDto;
import com.ms.model.User;

public interface UserService {
	boolean checkUser(UserDto user);

	User create(UserDto user);

	User findByEmail(String email);
}
