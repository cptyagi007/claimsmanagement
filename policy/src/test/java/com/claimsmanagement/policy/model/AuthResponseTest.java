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

public class AuthResponseTest {
	
	@InjectMocks
	AuthResponse authRes;
	
	
	@Test
	public void authResGetterSetterTest() {
		 //ares=new AuthResponse();
		authRes.setUid("uidcheck");
		authRes.setName("Namecheck");
		authRes.setValid(true);
		
		assertEquals("uidcheck",authRes.getUid());
		assertEquals("Namecheck",authRes.getName());
		assertEquals(true,authRes.isValid());
		
		}
	
	@Test
	public void authResConstructorTest() {
		
		assertNotNull(new AuthResponse());
		assertNotNull(new AuthResponse("uid","name",true));
		
	}
	
	
	

}