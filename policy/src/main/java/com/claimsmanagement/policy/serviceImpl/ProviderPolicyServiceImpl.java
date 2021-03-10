package com.claimsmanagement.policy.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimsmanagement.policy.dao.PolicyRepository;
import com.claimsmanagement.policy.dao.ProviderRepository;
import com.claimsmanagement.policy.exception.GlobalException;
import com.claimsmanagement.policy.exception.PolicyNotFoundException;
import com.claimsmanagement.policy.model.Policy;
import com.claimsmanagement.policy.model.Provider;
//import com.claimsmanagement.policy.proxy.AuthProxy;
import com.claimsmanagement.policy.service.ProviderPolicyService;

@Service
public class ProviderPolicyServiceImpl implements ProviderPolicyService {
	
	/**@Autowired
	private AuthProxy authProxy;**/
	@Autowired
	private PolicyRepository policyRepo;
 
	
	public Map<String,List<String>> getProvidersLocationWise(String token,long policyid)throws PolicyNotFoundException,GlobalException{
		 
		
		/****if(!authProxy.verifyToken(token).isValid()) {
			throw new GlobalException();
		}****/
		
		
		//Policy policy= policyRepo.findById(policyid).get();
		 
	Policy policy=policyRepo.findById(policyid).orElseThrow(()->new PolicyNotFoundException("Given Policy Id "+policyid+" did not exist"));
		
		
		Set<Provider> providers=policy.getProviders();
		
		Map<String,List<String>> map=new HashMap<>();
		
		for(Provider p:providers)
		{
			if(!map.containsKey(p.getLocation())) {
				map.put(p.getLocation(),new ArrayList<String>());}
			map.get(p.getLocation()).add(p.getProviderName());
			
			 
		}
		
		return map;
	}

}
