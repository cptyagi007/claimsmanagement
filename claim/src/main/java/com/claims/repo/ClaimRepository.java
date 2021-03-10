package com.claims.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claims.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
