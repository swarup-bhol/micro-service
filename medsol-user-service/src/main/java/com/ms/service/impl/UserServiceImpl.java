package com.ms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ms.dto.UserDto;
import com.ms.model.User;
import com.ms.repository.UserDao;
import com.ms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public boolean checkUser(UserDto userDto) {
		User user = userDao.findByUserEmail(userDto.getEmail());
		if (user == null) {
			return false;
		}
		return true;
	}

	@Override
	public User create(UserDto userDto) {
		User user = null;
		try {
			User newUser = new User();
			newUser.setUserEmail(userDto.getEmail());
			newUser.setUserMobile(userDto.getMobile());
			newUser.setFullName(userDto.getName());
			newUser.setUserPassword(bcryptEncoder.encode(userDto.getPassword()));
			newUser.setRecordStatus(true);
			user = userDao.save(newUser);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return user;
	}

}
