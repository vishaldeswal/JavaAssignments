package com.nagarro.EcommWebsite.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.EcommWebsite.dao.UserDao;
import com.nagarro.EcommWebsite.entity.JwtRequest;
import com.nagarro.EcommWebsite.entity.JwtResponse;
import com.nagarro.EcommWebsite.entity.User;
import com.nagarro.EcommWebsite.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private JwtUtil jwtUtil; 
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDao.findById(username).get();
		
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUserName(),
					user.getUserPassword(),
					getAuthorities(user)
					);
		}else {
			throw new UsernameNotFoundException("Username is not valid");
		}
	}
	
	private Set getAuthorities(User user) {
		Set authorities = new HashSet();
		
		user.getRole().forEach(role->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		});
		
		return authorities;
	}
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		String userName=jwtRequest.getUserName();
		String userPassword=jwtRequest.getUserPassword();
		
		authenticate(userName,userPassword);
		final UserDetails userDetails=loadUserByUsername(userName);
		String newGeneratedToken= jwtUtil.generateToken(userDetails);
		User user=userDao.findById(userName).get();
		
		return new JwtResponse(user, newGeneratedToken);
		
	}
	
	private void authenticate(String userName, String userPassword ) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));
		}catch(DisabledException e)
		{
			throw new Exception("User is disabled");
		}catch(BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
	}
}
