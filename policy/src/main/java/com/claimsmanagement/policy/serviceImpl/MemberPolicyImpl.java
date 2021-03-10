package com.claimsmanagement.policy.serviceImpl;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimsmanagement.policy.dao.MemberRepository;
import com.claimsmanagement.policy.dao.PolicyRepository;
import com.claimsmanagement.policy.exception.GlobalException;
import com.claimsmanagement.policy.exception.MemberNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotSubscribedException;
import com.claimsmanagement.policy.model.Benefits;
import com.claimsmanagement.policy.model.Member;
import com.claimsmanagement.policy.model.Policy;
//import com.claimsmanagement.policy.proxy.AuthProxy;
import com.claimsmanagement.policy.service.MemberPolicyService;

@Service
public class MemberPolicyImpl implements MemberPolicyService{
	
	/*
	 * @Autowired private AuthProxy authProxy;
	 */
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PolicyRepository policyRepo;

	public Set<String> getBenefits(String token,long policyId,long memberId)throws MemberNotFoundException,PolicyNotFoundException,PolicyNotSubscribedException,GlobalException
	{
		

		/***if(!authProxy.verifyToken(token).isValid()) {
			throw new GlobalException();
		}***/
		
		//Member m=memberRepo.findById(memberId).get();
		Member member=memberRepo.findById(memberId).orElseThrow(()->new MemberNotFoundException("Given member id "+memberId+" did not exist"));
		
		Set<Policy> subscribedPolicies=member.getSubscribedPolicies();
		
		
		
		  Policy inputPolicy=policyRepo.findById(policyId).orElseThrow(()->new PolicyNotFoundException("Given policy id "+policyId+" did not exist"));
		  
		 if(subscribedPolicies.contains(inputPolicy)) { 
				 
			 
		  Set<Benefits> benefits=inputPolicy.getBenefits();
		  
		  Set<String> benefitsSet=new HashSet<>();
		  for(Benefits benefit:benefits) {
			  
			  benefitsSet.add(benefit.getBenefit());
		  }
		  return benefitsSet;
		 
		 } 
		 else{
			 throw new PolicyNotSubscribedException("Given Policy is Not subscribed by Member");
	          }
		  
		 
			
		  
		 
			
		
	}
}
