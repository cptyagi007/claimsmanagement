package com.claims.proxy;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.policy.name}", url = "${feign.policy.url}")
public interface PolicyProxy {

	@Async
	@GetMapping("/getChainOfProviders")
	public Map<String, List<String>> getPolicyProviders(@RequestHeader(name = "Authorization") String token,
			@RequestParam("policyId") long policyId);

	@Async
	@GetMapping("/getEligibleBenefits")
	public Set<String> getPolicyBenefits(@RequestHeader(name = "Authorization") String token,
			@RequestParam("policyId") long policyId, @RequestParam("memberId") long memberId);

	@Async
	@GetMapping("/getEligibleClaimAmount")
	public double getPolicyAmount(@RequestHeader(name = "Authorization") String token,
			@RequestParam("policyId") long policyId, @RequestParam("memberId") long memberId,
			@RequestParam("benefitId") long benefitId);

}
