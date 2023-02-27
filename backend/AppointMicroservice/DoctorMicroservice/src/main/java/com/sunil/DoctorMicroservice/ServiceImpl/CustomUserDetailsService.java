package com.sunil.DoctorMicroservice.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sunil.DoctorMicroservice.Repository.DoctorRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	public DoctorRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(!repo.findByusername(username).isEmpty())
		{
			return new User(username,repo.findByusername(username).getPassword(),new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User not found !!");
		}
	}
	

}