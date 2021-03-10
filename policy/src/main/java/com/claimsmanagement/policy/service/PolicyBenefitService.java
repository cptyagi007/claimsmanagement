package com.claimsmanagement.policy.service;

import com.claimsmanagement.policy.exception.BenefitNotFoundException;
import com.claimsmanagement.policy.exception.MemberNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotSubscribedException;

public interface PolicyBenefitService {
	
	public double getAmount(String token,long policyId,long memberId,long benefitId)throws MemberNotFoundException,PolicyNotFoundException,PolicyNotSubscribedException,BenefitNotFoundException,Exception;

}
