package com.claims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claims.exception.ClaimNotFoundException;
import com.claims.exception.InvalidSessionException;
import com.claims.exception.MemberNotFoundException;
import com.claims.exception.PolicyNotFoundException;
import com.claims.model.Claim;
import com.claims.service.ClaimService;

@RestController
public class ClaimController {

	@Autowired
	private ClaimService service;

	@GetMapping("/getClaimStatus")
	public ResponseEntity<?> getClaimStatus(@RequestHeader("Authorization") String token,
			@RequestParam("claimId") long claimId, @RequestParam("policyId") long policyId,
			@RequestParam("memberId") long memberId)
			throws ClaimNotFoundException, PolicyNotFoundException, MemberNotFoundException {
		Claim claim = service.getClaim(token, claimId, policyId, memberId);
		return new ResponseEntity<>(claim.getClaimStatus(), HttpStatus.OK);
	}

	@PostMapping("/submitclaim")
	public ResponseEntity<?> submitClaim(@RequestHeader("Authorization") String token,
			@RequestParam("policyId") long policyId, @RequestParam("memberId") long memberId,
			@RequestParam("hsptlId") long hsptlId, @RequestParam("benefitId") long benefitId,
			@RequestParam("benefit") String benefit, @RequestParam("hospitalName") String hospitalName,
			@RequestParam("bill") double bill, @RequestParam("claim") double claim,
			@RequestParam("location") String location) throws InvalidSessionException {
		return new ResponseEntity<>(service.submitClaim(token, policyId, memberId, hsptlId, benefitId, benefit,
				hospitalName, bill, claim, location), HttpStatus.OK);
	}

}
