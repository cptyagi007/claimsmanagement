package com.claimsmanagement.policy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claimsmanagement.policy.model.Benefits;

public interface BenefitsRepository extends JpaRepository<Benefits, Long> {

}
