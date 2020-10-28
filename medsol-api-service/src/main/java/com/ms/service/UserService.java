package com.ms.service;

import com.ms.model.LoginUser;
import com.ms.model.User;
import com.ms.model.UserDto;

public interface UserService {

	boolean checkUser(UserDto user);

	User save(User user);

	User save(UserDto user);

	boolean loginUser(LoginUser loginUser);

	Object generateToken(String email);

}
