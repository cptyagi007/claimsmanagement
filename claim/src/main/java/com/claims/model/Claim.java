package com.claims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Claim {
	
	@Id
	@GeneratedValue
	private long claimId;
	private long policyId;
	private long memberId;
	private long hsptlId;
	private long benefitId;
	private String benefit;
	private String hospitalName;
	private double bill;
	private double claim;
	private String claimStatus;

}
