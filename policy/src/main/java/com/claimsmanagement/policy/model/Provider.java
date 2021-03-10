package com.claimsmanagement.policy.model;




import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Provider {
	

    @Id
    private long providerId;
    @Column(name="provider_name")
    private String providerName;
    @Column(name="location")
    private String location;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="Provider_Policy",joinColumns={@JoinColumn(name="providerid")},inverseJoinColumns={@JoinColumn(name="policyid")})
    private Set<Policy> policies;


}
