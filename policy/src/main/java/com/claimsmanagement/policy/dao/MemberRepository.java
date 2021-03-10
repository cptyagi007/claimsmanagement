package com.claimsmanagement.policy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claimsmanagement.policy.model.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
