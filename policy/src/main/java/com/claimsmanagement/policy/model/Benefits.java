package com.claimsmanagement.policy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Benefits {
	
	@Id
	@GeneratedValue
	@Column(name = "benefit_id")
	private long benefitId;
	@Column(name="benefit")
	private String benefit;
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "benefits")
	private Set<Policy> policies;

}
