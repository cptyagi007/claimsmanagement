package com.claimsmanagement.policy.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claimsmanagement.policy.model.Provider;



public interface ProviderRepository extends JpaRepository<Provider, Long>{

}
