package com.mycompany.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 2887448426662334370L;

	private User user;

	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Arrays.stream(user.getGrantedAuthorities()).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getIsAccountLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getIsCredentialsExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.getIsEnabled();
	}

}