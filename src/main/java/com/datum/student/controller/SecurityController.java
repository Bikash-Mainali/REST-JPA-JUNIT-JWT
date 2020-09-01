package com.datum.student.controller;

import com.datum.student.security.AuthenticationRequest;
import com.datum.student.security.JwtUtil;
import com.datum.student.service.AdminUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecurityController {

    private AuthenticationManager authenticationManager;

    private AdminUserDetailsServiceImpl adminUserDetailsService;

    private JwtUtil jwtTokenUtil;


    public SecurityController(AuthenticationManager authenticationManager, AdminUserDetailsServiceImpl adminUserDetailsService,JwtUtil jwtUtil){

        this.authenticationManager=authenticationManager;
        this.jwtTokenUtil=jwtUtil;
        this.adminUserDetailsService=adminUserDetailsService;
    }


    //generating jwt token
    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("authenticate controller....");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = adminUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        System.out.println(jwt);
        return jwt;

    }
}
