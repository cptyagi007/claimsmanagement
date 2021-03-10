package com.claimsmanagement.policy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.claimsmanagement.policy.dao.PolicyRepository;
import com.claimsmanagement.policy.exception.GlobalException;
import com.claimsmanagement.policy.exception.PolicyNotFoundException;
import com.claimsmanagement.policy.model.Policy;
import com.claimsmanagement.policy.model.Provider;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProviderPolicyServiceTest {
	
	@InjectMocks
	ProviderPolicyService providerPolicyService;
	
	@Mock
	PolicyRepository policyRepo;
	@Mock
	Policy policy;
	
	
	@Test
	public void  getProvidersLocationWiseTest() throws PolicyNotFoundException, GlobalException {
		
		Map<String,List<String>> map=new HashMap<>();
		
		Mockito.when(policyRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(policy));
		Mockito.when(policy.getProviders()).thenReturn(Mockito.anySet());
		
		//Set<Provider> providers=policy.getProviders();
		//Mockito.when(providerPolicyService.getProvidersLocationWise(Mockito.anyString(),Mockito.anyLong())).thenReturn(map);
		
		providerPolicyService.getProvidersLocationWise(Mockito.anyString(),Mockito.anyLong());
		
		Mockito.verify(policyRepo).findById(Mockito.anyLong());
		Mockito.verify(policy).getProviders();
		//Mockito.verify(providerPolicyService).getProvidersLocationWise(Mockito.anyString(), Mockito.anyLong());		
		
		
		
		
	}

}
