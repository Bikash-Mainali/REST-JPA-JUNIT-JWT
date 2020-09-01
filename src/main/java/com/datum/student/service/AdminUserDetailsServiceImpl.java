package com.datum.student.service;

import com.datum.student.domain.Admin;
import com.datum.student.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        List<Admin> admin=adminRepository.findAll();

        String userName=admin.get(0).getUserName();
        String password=admin.get(0).getPassword();
        System.out.println(userName);
        System.out.println(password);
        return new User(userName, password, new ArrayList<>());
    }
}
