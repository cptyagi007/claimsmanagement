
package com.claims.proxy;

import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.claims.model.AuthResponse;


@FeignClient(name = "${feign.auth.name}" , url = "${feign.auth.url}")
public interface AuthProxy {

	@GetMapping("/authapp/validate")
	public AuthResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
