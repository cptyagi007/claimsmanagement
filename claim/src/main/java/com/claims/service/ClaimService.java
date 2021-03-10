package com.claims.service;
 
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claims.exception.ClaimNotFoundException;
import com.claims.exception.InvalidSessionException;
import com.claims.exception.MemberNotFoundException;
import com.claims.exception.PolicyNotFoundException;
import com.claims.model.Claim;
import com.claims.proxy.AuthProxy;
import com.claims.proxy.PolicyProxy;
import com.claims.repo.ClaimRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClaimService {

	@Autowired
	private ClaimRepository repo;
	
	@Autowired
	private AuthProxy proxy;
	
	@Autowired
	private PolicyProxy policyProxy;

	public Claim submitClaim(String token , long policyId, long memberId, long hsptlId, long benefitId, String benefit,
			String hospitalName, double bill , double claim , String location) throws InvalidSessionException {
		if(!proxy.verifyToken(token).isValid()) {
			throw new InvalidSessionException("You logged out. login again.");
		}
		Map<String , List<String>> hospitals = policyProxy.getPolicyProviders(token, policyId);
		Set<String> benefits = policyProxy.getPolicyBenefits(token, policyId, memberId);
		double insuredAmount = policyProxy.getPolicyAmount(token, policyId, memberId, benefitId);
		log.debug("{}" , hospitals);
		log.debug("{}" , benefits);
		log.debug("{}" , insuredAmount);
		Claim c = new Claim();
		c.setPolicyId(policyId);
		c.setMemberId(memberId);
		c.setHsptlId(hsptlId);
		c.setBenefitId(benefitId);
		c.setBenefit(benefit);
		c.setHospitalName(hospitalName);
		c.setBill(bill);
		c.setClaim(claim);
		if(claim <= insuredAmount) {
			if(!hospitals.containsKey(location)) {
				c.setClaimStatus("Insufficient Claim Details : location");
			}
			else if(!hospitals.get(location).contains(hospitalName)) {
				c.setClaimStatus("Insufficient Claim Details : hospital name");
			}
			else if(!benefits.contains(benefit)) {
				c.setClaimStatus("Insufficient Claim Details : benefit");
			}
			else if(bill < claim) {
				c.setClaimStatus("Under Dispute : bill");
			}
			else
				c.setClaimStatus("Pending Action");
		}
		else
			c.setClaimStatus("Rejected");
		return repo.save(c);
	}

	public Claim getClaim(String token, long claimId, long policyId, long memberId) throws ClaimNotFoundException, PolicyNotFoundException, MemberNotFoundException {
		Claim claim = repo.findById(claimId).orElseThrow( ()-> new ClaimNotFoundException("Claim not found.") );
		if(claim.getPolicyId() != policyId) {
			throw new PolicyNotFoundException("Incorrect Policy");
		}
		if(claim.getMemberId() != memberId) {
			throw new MemberNotFoundException("Member Not Found");
		}
		return claim;
	}

}
