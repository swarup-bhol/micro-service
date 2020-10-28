package com.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dto.Constants;
import com.ms.dto.Response;
import com.ms.dto.UserDto;
import com.ms.model.User;
import com.ms.service.CommonService;
import com.ms.service.UserService;

@RestController
@RequestMapping("/medsol/api/v1/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	CommonService cs;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/register")
	public Response<Object> registerUSer(@RequestBody UserDto user) {
		
		Response<Object> response = null;

		try {
			boolean userExist = userService.checkUser(user);
			if (!userExist) {
				response = cs.response(HttpStatus.OK.value(), Constants.CREATED, userService.create(user));
			}
			response = cs.response(409, Constants.USER_EXIST, user);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<Object> findUserByEmail(@PathVariable String email) {
		
		  User user = userService.findByEmail(email);  
		  if(user != null) {
			  return ResponseEntity.ok(user);
		  }
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(email);
	}
	

}
