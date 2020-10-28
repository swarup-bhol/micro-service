package com.ms.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ms.model.LoginUser;
import com.ms.model.User;
import com.ms.model.UserDto;
import com.ms.repository.MedsolUserServiceProxy;
import com.ms.service.UserService;



@Service(value = "userService")
public class UserServiceImpl implements UserService , UserDetailsService{

	@Autowired
	MedsolUserServiceProxy proxy;
	
	@Override
	public boolean checkUser(UserDto user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginUser(LoginUser loginUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object generateToken(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  proxy.findUserByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(),user.getUserPassword(),getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority(){
		return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
	}
}
