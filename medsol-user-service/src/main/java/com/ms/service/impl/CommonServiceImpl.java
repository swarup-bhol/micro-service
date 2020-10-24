package com.ms.service.impl;

import org.springframework.stereotype.Service;

import com.ms.dto.Response;
import com.ms.service.CommonService;


@Service
public class CommonServiceImpl implements CommonService{

	@Override
	public Response<Object> response(int status, String msg, Object res) {
		Response<Object> response = new Response<>(status, msg, res);
		return response;
	}

	

}
