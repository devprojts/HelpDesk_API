package com.crissantos.helpdesk.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.crissantos.helpdesk.api.entity.User;
import com.crissantos.helpdesk.api.enums.ProfileEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {}
	
	public static JwtUser create(User user) {
		return new  JwtUser(user.getId(), 
				user.getEmail(), 
				user.getPassword(), 
				mapGrantedAuthorities(user.getProfile())
				);
	}
	
	private static List<GrantedAuthority> mapGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}	 
}
