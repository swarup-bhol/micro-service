package com.ms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class LoginUser {

	private String email;
	private String password;
}
