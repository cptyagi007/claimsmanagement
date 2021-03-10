package com.claimsmanagement.policy.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimsmanagement.policy.dao.MemberRepository;
import com.claimsmanagement.policy.dao.PolicyRepository;
import com.claimsmanagement.policy.exception.BenefitNotFoundException;
import com.claimsmanagement.policy.exception.MemberNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotSubscribedException;
import com.claimsmanagement.policy.model.Benefits;
import com.claimsmanagement.policy.model.Member;
import com.claimsmanagement.policy.model.Policy;
import com.claimsmanagement.policy.service.PolicyBenefitService;

@Service
public class PolicyBenefitServiceImpl implements PolicyBenefitService{

	@Autowired 
	private MemberRepository memberRepo;
	
	@Autowired
	private PolicyRepository policyRepo;
	
	@Override
	public double getAmount(String token, long policyId, long memberId, long benefitId)
			throws MemberNotFoundException,PolicyNotFoundException,PolicyNotSubscribedException,BenefitNotFoundException,Exception {
		
		Member member=memberRepo.findById(memberId).orElseThrow(()->new MemberNotFoundException("Given member id "+memberId+" did not exist"));

		Set<Policy> subscribedPolicies=member.getSubscribedPolicies();
		
			Policy policy=policyRepo.findById(policyId).orElseThrow(()->new PolicyNotFoundException("Given policy id "+policyId+" did not exist"));
				 
			 if(subscribedPolicies.contains(policy)) {
				 Set<Benefits> benefits=policy.getBenefits();
				  
				   boolean flag=false;
				  for(Benefits benefit:benefits)
				  {
					  if(benefitId == benefit.getBenefitId()) {
						  flag=true;
					  }
						 
				  }
				  if(flag) {
					  return policy.getSumInsured();
				  }
				  else {
					  throw new BenefitNotFoundException("Given benefit id did not exist");
				  }
			 }
			 else
			 {
				 throw new PolicyNotSubscribedException("Given Policy Id "+policyId+" did not exist");
			 }
		
				  
			  
		
	}
	

}
