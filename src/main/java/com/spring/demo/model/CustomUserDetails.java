package com.spring.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	private String username,password;
	List<GrantedAuthority> roles = new ArrayList<>();
	public CustomUserDetails(UserModel user){
		if(user!=null) {
			this.username=user.getUsername();
			this.password=user.getPassword();
			if(user.getRoles()!=null) {
				List<String> roles = Arrays.asList(user.getRoles().split(","));
				roles.stream().forEach(role->{
					this.roles.add(new SimpleGrantedAuthority(role));
				});
			}else {
				throw new IllegalArgumentException("user roles can be null");
			}
		}else {
			throw new IllegalArgumentException("user can not be null");
		}
	}
	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
