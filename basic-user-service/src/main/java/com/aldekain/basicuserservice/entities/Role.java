package com.aldekain.basicuserservice.entities;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="roles")
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = -4905704218931837269L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Basic
	private String authority;

	@ManyToMany(mappedBy = "authorities")
	private Set<User> users;
	
	public Role(){
	}
	
	public Role(String authority){
		this();
		this.setAuthority(authority);
	}
	
	
	@Override
	public String getAuthority() {
		return this.authority;
	}
	
	public void setAuthority(String authority) {
		this.authority=authority;
	}
	
}

