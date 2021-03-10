package com.claimsmanagement.policy.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claimsmanagement.policy.exception.BenefitNotFoundException;
import com.claimsmanagement.policy.exception.GlobalException;
import com.claimsmanagement.policy.exception.MemberNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotSubscribedException;
import com.claimsmanagement.policy.model.Benefits;
import com.claimsmanagement.policy.service.MemberPolicyService;
import com.claimsmanagement.policy.service.PolicyBenefitService;
import com.claimsmanagement.policy.service.ProviderPolicyService;

@RestController
public class PolicyController {

	@Autowired
	private ProviderPolicyService providerPolicyService;

	@Autowired
	private MemberPolicyService memberPolicyService;
	
	@Autowired
	private PolicyBenefitService policyBenefitService;

	@GetMapping("/getChainOfProviders")
	public ResponseEntity<Map<String, List<String>>> getPolicyProviders(
			@RequestHeader(name = "Authorization") String token, @RequestParam("policyId") long policyId)
			throws PolicyNotFoundException,GlobalException {


		Map<String, List<String>> chainOfProviders = providerPolicyService.getProvidersLocationWise(token, policyId);
		
		return new ResponseEntity<>(chainOfProviders, HttpStatus.OK);

	}

	@GetMapping("/getEligibleBenefits")
 public ResponseEntity<Set<String>> getPolicyBenefits(@RequestHeader(name = "Authorization") String token,@RequestParam("policyId") long policyId,@RequestParam("memberId") long memberId)throws MemberNotFoundException,PolicyNotFoundException,PolicyNotSubscribedException,GlobalException 
 {
	  
	 Set<String> benefits= memberPolicyService.getBenefits(token, policyId, memberId);
	 return new ResponseEntity<>(benefits, HttpStatus.OK);
 }

	@GetMapping("/getEligibleClaimAmount")
 public ResponseEntity<?> getPolicyAmount(@RequestHeader(name = "Authorization") String token,@RequestParam("policyId") long policyId,@RequestParam("memberId") long memberId,@RequestParam("benefitId") long benefitId)throws MemberNotFoundException,PolicyNotFoundException,PolicyNotSubscribedException,BenefitNotFoundException,Exception {
	  
		
	 double amount=policyBenefitService.getAmount(token, policyId, memberId, benefitId);
	 
	 return new ResponseEntity<>(amount, HttpStatus.OK);
	 
 }
	
	
	
}

 
 
 

    

