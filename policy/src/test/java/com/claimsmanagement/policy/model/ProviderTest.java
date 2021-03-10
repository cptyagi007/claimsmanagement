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
public class ProviderTest {
	
	@InjectMocks
	Provider provider;
	
	@Test
	public void providerGetterSetterTest() {
		provider.setProviderId(Mockito.anyLong());
		provider.setProviderName(Mockito.anyString());
		provider.setLocation(Mockito.anyString());
		provider.setPolicies(Mockito.anySet());
		
		assertEquals(Mockito.anyLong(),provider.getProviderId());
		assertEquals(Mockito.anyString(),provider.getProviderName());
		assertEquals(Mockito.anyString(),provider.getLocation());
		assertEquals(Mockito.anySet(),provider.getPolicies());
	}
	
	@Test
	public void providerConstructorTest() {
		
		assertNotNull(new Provider());
		assertNotNull(new Provider(Mockito.anyLong(),Mockito.anyString(),Mockito.anyString(),Mockito.anySet()));
		
		
		
	}

}
