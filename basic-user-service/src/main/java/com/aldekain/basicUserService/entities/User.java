package com.aldekain.basicUserService.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails{


		private static final long serialVersionUID = -3232685336074553632L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
		private int id;
		
	    @Column(name="username", unique=true, nullable=false)
		private String username;

	    @Column(name="password", nullable=false)
		private String password;

	    @Basic
		private boolean isAccountNonExpired;

	    @Basic
		private boolean isAccountNonLocked;

	    @Basic
		private boolean isCredentialsNonExpired;

	    @Basic
		private boolean isEnabled;
	    
		@Column(name="email",unique=true)
		private String email;
	    
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name = "users_roles",
		joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false) })
		private Set<Role> authorities;
		
	
	public User() {
		 this.setAccountNonExpired(true);
	     this.setAccountNonLocked(true);
	     this.setEnabled(true);
	     this.setCredentialsNonExpired(true);
	     this.authorities=new HashSet<>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}


	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}


	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}


	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}


	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}


	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}


	public boolean isEnabled() {
		return isEnabled;
	}


	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set<Role> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

}
