package com.claimsmanagement.policy.model;





import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Policy {
	
	@Id
    private long policyId;
	
	@Column(name="policy_name")
	private String policyName;
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(name="Policy_Benefit",joinColumns={@JoinColumn(name="policy_id")},inverseJoinColumns={@JoinColumn(name="benefit_id")})
    private Set<Benefits> benefits;
	
	@Column(name="sum_insured")
	private double sumInsured;
   
    @Column(name="premium")
    private long premium;
   
    @Column(name="tenure")
    private int tenure;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="policies")
    private Set<Provider> providers;
  
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "subscribedPolicies")
	private Set<Member> members;
 

}
