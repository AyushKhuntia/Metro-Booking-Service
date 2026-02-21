package com.moveinsync.assignment.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.moveinsync.assignment.entity.UserInfo;
import com.moveinsync.assignment.repository.UserInfoRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserInfoRepository userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoDAO.getByUsername(username);
		
//		for multiple roles set<role> roles
//	    List<GrantedAuthority> authorities =
//	            userInfo.getRoles().stream()
//	                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//	                .collect(Collectors.toList());
	    
		GrantedAuthority grantAuthority =
	            new SimpleGrantedAuthority("ROLE_" + userInfo.getRole());
		User user = new User(userInfo.getUsername(), userInfo.getPassword(), Arrays.asList(grantAuthority));
		
		return (UserDetails) user;
	}


}
