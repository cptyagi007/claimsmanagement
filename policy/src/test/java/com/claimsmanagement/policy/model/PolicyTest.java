package com.claimsmanagement.policy.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PolicyTest {
	
	@InjectMocks
	Policy policy;
	
	
	@Test
	public void policyGetterSetterTest() {
		policy.setPolicyId(Mockito.anyLong());
		policy.setPolicyName(Mockito.anyString());
		policy.setPremium(Mockito.anyLong());
		policy.setSumInsured(Mockito.anyDouble());
		policy.setTenure(Mockito.anyInt());
		policy.setBenefits(Mockito.anySet());
		policy.setMembers(Mockito.anySet());
		policy.setProviders(Mockito.anySet());
		
		assertEquals(Mockito.anyLong(),policy.getPolicyId());
		assertEquals(Mockito.anyString(),policy.getPolicyName());
		assertEquals(Mockito.anyLong(),policy.getPremium());
		assertEquals(Mockito.anyDouble(),policy.getSumInsured());
		assertEquals(Mockito.anyInt(),policy.getTenure());
		assertEquals(Mockito.anySet(),policy.getBenefits());
		assertEquals(Mockito.anySet(),policy.getMembers());
		assertEquals(Mockito.anySet(),policy.getProviders());
	}
	
	@Test
	public void policyConstructorTest() {
		assertNotNull(new Policy());
		assertNotNull(new Policy(Mockito.anyLong(),Mockito.anyString(),Mockito.anySet(),Mockito.anyDouble(),Mockito.anyLong(),Mockito.anyInt(),Mockito.anySet(),Mockito.anySet()));
	}
}
