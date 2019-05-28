package model.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DemoUserDetailsService implements UserDetailsService {

	public String password = "password";
	public String uzername = "username";
	public Boolean accountNonExpired = true;
	public Boolean accountNonLocked = true;
	public Boolean credentialsNonExpired = true;
	public Boolean enabled = true;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		@SuppressWarnings("serial")
		UserDetails customUserDetails = new UserDetails() {

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return null;
			}

			@Override
			public String getPassword() {
				return password;
			}

			@Override
			public String getUsername() {
				return uzername;
			}

			@Override
			public boolean isAccountNonExpired() {
				return accountNonExpired;
			}

			@Override
			public boolean isAccountNonLocked() {
				return accountNonLocked;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return credentialsNonExpired;
			}

			@Override
			public boolean isEnabled() {
				return enabled;
			}};
		
		return customUserDetails;
	}

}
