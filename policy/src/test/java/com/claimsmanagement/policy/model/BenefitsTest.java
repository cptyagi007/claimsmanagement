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
public class BenefitsTest {
	
	@InjectMocks
	Benefits benefit;
	
	@Test
	public void benefitsGetterSetterTest() {
		benefit.setBenefitId(Mockito.anyLong());
		benefit.setBenefit(Mockito.anyString());
		benefit.setPolicies(Mockito.anySet());
		
		assertEquals(Mockito.anyLong(),benefit.getBenefitId());
		assertEquals(Mockito.anyString(),benefit.getBenefit());
		assertEquals(Mockito.anySet(),benefit.getPolicies());
		
	}
	
	@Test
	public void benefitConstructorTest() {
		assertNotNull(new Benefits());
		assertNotNull(new Benefits(Mockito.anyLong(),Mockito.anyString(),Mockito.anySet()));
		
	}

}
