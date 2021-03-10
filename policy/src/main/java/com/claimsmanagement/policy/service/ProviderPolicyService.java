package com.claimsmanagement.policy.service;


import java.util.List;
import java.util.Map;

import com.claimsmanagement.policy.exception.GlobalException;
import com.claimsmanagement.policy.exception.PolicyNotFoundException;



public interface ProviderPolicyService {

    public Map<String,List<String>> getProvidersLocationWise(String token,long policyid)throws PolicyNotFoundException,GlobalException;

}
