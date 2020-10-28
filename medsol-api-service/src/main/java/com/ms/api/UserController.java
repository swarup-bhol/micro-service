package com.ms.api;

import org.apache.http.auth.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.LoginUser;
import com.ms.model.UserDto;
import com.ms.service.UserService;

@RequestMapping("/api/medsol/v1")
@RestController
public class UserController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	/**
	 * @author swarup bhol
	 *
	 * @purpose create a new user
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public ResponseEntity<Object> createUser(@RequestBody UserDto user) {
		boolean userExist = userService.checkUser(user);
		if (!userExist) {
			return ResponseEntity.ok(userService.save(user));
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
	}

	/**
	 *
	 * @author swarup
	 *
	 * @purpose login an user
	 * 
	 * @param loginUser
	 * @return
	 * @throws AuthenticationException
	 * @throws InvalidUserNamePasswordException
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody LoginUser loginUser) throws AuthenticationException {
		if (loginUser == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginUser);
		} else {

			boolean result = userService.loginUser(loginUser);
			if (result) {
				return ResponseEntity.ok(userService.generateToken(loginUser.getEmail()));
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(loginUser);
		}
	}

}
