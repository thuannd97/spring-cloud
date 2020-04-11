package com.thuannd.securityoauth2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thuannd.securityoauth2.entities.Role;
import com.thuannd.securityoauth2.entities.User;
import com.thuannd.securityoauth2.repositories.RoleRepository;
import com.thuannd.securityoauth2.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        userOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        User user = userOptional.get();
        Optional<Role> roleOptional = roleRepository.findById(user.getRoleId());
        roleOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        Role role = roleOptional.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}