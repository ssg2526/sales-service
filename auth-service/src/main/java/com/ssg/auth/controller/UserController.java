package com.ssg.auth.controller;

import com.ssg.auth.model.AuthRequest;
import com.ssg.auth.model.AuthResponse;
import com.ssg.auth.model.User;
import com.ssg.auth.service.UserService;
import com.ssg.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("auth/api/v1")
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@RequestBody User user, @RequestHeader Map<String, Object> headers) {
        return userService.registerNewUser(user);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest authRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
            );
        } catch (Exception e){
            throw new BadCredentialsException("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}