package com.example.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mapper.HomeMapper;
import com.example.vo.MemberVO;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	HomeMapper hMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = hMapper.findByID(username);
		
		System.out.println(vo.toString());

		String[] auth = { vo.getAuth() };
		Collection<GrantedAuthority> roles = AuthorityUtils.createAuthorityList(auth);
		
		//return new User(vo.getId(),vo.getPw(),roles);
		return new MyUser(
				vo.getId(), vo.getPw(), 
				roles, 
				vo.getUniv_name(), vo.getDept_name(), 
				vo.getStu_name(), vo.getStu_num(), 
				vo.getStu_grd(), vo.getAuth());
	}

}
