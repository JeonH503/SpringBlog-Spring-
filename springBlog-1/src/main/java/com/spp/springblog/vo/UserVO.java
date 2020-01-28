package com.spp.springblog.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserVO {
	
	private String vusername;
	private String vpassword;
	private boolean isAccountNonExpired; 
	private boolean isAccountNonLocked; 
	private boolean isCredentialsNonExpired; 
	private boolean isEnabled; 
	private Collection <?extends GrantedAuthority> authorities;
	public String getVusername() {
		return this.vusername;
	}
	public void setVusername(String vusername) {
		this.vusername = vusername;
	}
	public String getVpassword() {
		return this.vpassword;
	}
	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}
	public boolean isAccountNonExpired() {
		return this.isAccountNonExpired;
	}
	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked;
	}
	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	public boolean isEnabled() {
		return this.isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}




	
}
