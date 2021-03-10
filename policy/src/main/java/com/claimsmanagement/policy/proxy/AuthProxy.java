/*
 * package com.claimsmanagement.policy.proxy;
 * 
 * import org.springframework.cloud.openfeign.FeignClient; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestHeader;
 * 
 * import com.claimsmanagement.policy.model.AuthResponse;
 * 
 * @FeignClient(name="${feign.name.auth}") public interface AuthProxy {
 * 
 * @GetMapping("/authapp/validate") public AuthResponse
 * verifyToken(@RequestHeader(name="Authorization",required=true) String token);
 * 
 * 
 * }
 */