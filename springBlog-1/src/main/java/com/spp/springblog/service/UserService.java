package com.spp.springblog.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spp.springblog.dao.UserDao;
import com.spp.springblog.vo.UserVO;

@Service
public class UserService implements UserDetailsService,IUserService {
	@Autowired
	UserDao userDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(UserVO userVo,String role) {
		userVo.setVpassword(passwordEncoder.encode(userVo.getVpassword()));
		userVo.setAccountNonExpired(true); 
		userVo.setAccountNonLocked(true); 
		userVo.setCredentialsNonExpired(true); 
		userVo.setEnabled(true);
		userDao.saveUser(userVo,role);
	}

	@Override
	public UserDetails loadUserByUsername(String vusername) throws UsernameNotFoundException {
		UserVO userVo = userDao.findByUsername(vusername);
		String role = userDao.findRoleByUsername(vusername);
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		
		return new User(userVo.getVusername(),userVo.getVpassword(),authorities);
			
	}

	@Override
	public boolean userDelete(UserVO userVo) {
		UserVO oldUserVo = userDao.findByUsername(userVo.getVusername());
		if(passwordEncoder.matches(userVo.getVpassword(),oldUserVo.getVpassword())) {
			userDao.userDelete(userVo);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean userUpdate(UserVO userVo, String oldVpassword) {
		UserVO oldUserVo = userDao.findByUsername(userVo.getVusername());
		if(passwordEncoder.matches(oldVpassword,oldUserVo.getVpassword())) {
			userVo.setVpassword(passwordEncoder.encode(userVo.getVpassword()));
			userDao.userUpdate(userVo);
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public int idchk(UserVO userVo) {
		return userDao.idchk(userVo);
	}
	
	
}
