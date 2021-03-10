package com.claimsmanagement.policy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.claimsmanagement.policy.dao.MemberRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberPolicyServiceTest {
	
	@InjectMocks
	MemberPolicyService memberPolicyService;
	
	@Mock
	MemberRepository memberRepo;
	
	@Test
	public void getBenefitsTest() {
		
	}
	

}
