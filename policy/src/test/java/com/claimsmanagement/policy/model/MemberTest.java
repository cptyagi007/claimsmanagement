package com.claimsmanagement.policy.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberTest {
	
	@InjectMocks
	Member member;
	
	@Test
	public void memberGetterSetterTest() {
		
		member.setMemberId(Mockito.anyLong());
		member.setSubscriptionDate(new Date(21/11/2020));
		member.setAmount(Mockito.anyDouble());
	    member.setSubscribedPolicies(Mockito.anySet());
	    
	    assertEquals(Mockito.anyLong(),member.getMemberId());
	    assertEquals(new Date(21/11/2020),member.getSubscriptionDate());
	    assertEquals(Mockito.anyDouble(),member.getAmount());
	    assertEquals(Mockito.anySet(),member.getSubscribedPolicies());
	    
		}
	
	@Test
	public void memberConstructorTest() {
		assertNotNull(new Member());
		assertNotNull(new Member(Mockito.anyLong(),new Date(21/11/2020),Mockito.anyDouble(),Mockito.anySet()));
		
	}

}
