package com.claimsmanagement.policy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claimsmanagement.policy.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
