package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import model.dao.MemberDao;

@Component
public class DemoUserDetailsService implements UserDetailsService {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails result = 
				User.builder()
				.username("user")
				.password(passwordEncoder.encode("ahaha"))
				.accountExpired(false)
				.accountLocked(false)
				.authorities("guest","admin")
				.credentialsExpired(false)
				.disabled(false)
				.build();
		return result;
	}

}
