package com.ms.repository;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ms.model.User;

@FeignClient(name = "medsol-user-service")
@RibbonClient()
public interface MedsolUserServiceProxy {

	@PostMapping("medsol/api/v1/user/{email}")
	User findUserByEmail(@PathVariable("email") String username);

}
