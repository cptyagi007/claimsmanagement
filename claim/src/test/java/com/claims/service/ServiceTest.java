package com.claims.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.claims.exception.InvalidSessionException;
import com.claims.model.AuthResponse;
import com.claims.model.Claim;
import com.claims.proxy.AuthProxy;
import com.claims.proxy.PolicyProxy;
import com.claims.repo.ClaimRepository;

@SpringBootTest
public class ServiceTest {

	@InjectMocks
	ClaimService cs;
	
	@Mock
	ClaimRepository repo;
	
	@Mock
	AuthProxy proxy;
	
	@Mock
	PolicyProxy policyproxy;

	@Mock 
	Claim claim;
	
	@Test
	public void submitClaimPendingTest() throws InvalidSessionException {
		Map<String,List<String>> hospital= new HashMap<>();
		ArrayList<String> al=new ArrayList();
		al.add("MAX");
		hospital.put("location",al);
		Set<String> benefits = new HashSet<>();
		benefits.add("Critical Illness");
		
		claim=new  Claim(1l,1l, 1l, 1l, 1l,"Critical Illness" ,"MAX", 120d, 80d,"Pending Action");
		
		Mockito.when(proxy.verifyToken("token")).thenReturn(new AuthResponse("","",true));
		Mockito.when(policyproxy.getPolicyProviders("token", 1)).thenReturn(hospital);
		Mockito.when(policyproxy.getPolicyBenefits("token", 1, 1)).thenReturn(benefits);
		Mockito.when(policyproxy.getPolicyAmount("token", 1, 1, 1)).thenReturn(100.0);
		Mockito.when(repo.save(claim)).thenReturn(claim);
		Claim clam=cs.submitClaim("token", 1, 1, 1, 1,"Critical Illness" ,"MAX", 120, 80,"location");
		boolean result=clam.getClaimStatus().equals(claim.getClaimStatus());
		assertEquals(true,result);
	}
	
}
