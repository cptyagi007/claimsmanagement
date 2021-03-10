package com.claimsmanagement.policy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private long memberId;
	@Column(name = "subscription_date")
	@Temporal(TemporalType.DATE)
	private Date subscriptionDate;
	
	@Column(name="amount")
	private double amount;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Member_Policy", joinColumns = { @JoinColumn(name = "member_id") }, inverseJoinColumns = {
			@JoinColumn(name = "policy_id") })
	private Set<Policy> subscribedPolicies;

}
