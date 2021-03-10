package com.claimsmanagement.policy.service;



import java.util.Set;

import com.claimsmanagement.policy.exception.GlobalException;
import com.claimsmanagement.policy.exception.MemberNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotFoundException;
import com.claimsmanagement.policy.exception.PolicyNotSubscribedException;


public interface MemberPolicyService {
	
 public Set<String> getBenefits(String token,long policyId,long memberId)throws MemberNotFoundException,PolicyNotFoundException,PolicyNotSubscribedException,GlobalException;

}
