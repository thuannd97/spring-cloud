package com.thuannd.oauth2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thuannd.oauth2.dao.RoleDAO;
import com.thuannd.oauth2.dao.UserDAO;
import com.thuannd.oauth2.model.Role;
import com.thuannd.oauth2.model.User;

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
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userDAO.findByUsername(username);
        userOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        User user = userOptional.get();
        Optional<Role> roleOptional = roleDAO.findByRoleId(user.getRoleId());
        roleOptional.orElseThrow(() -> new UsernameNotFoundException("Role not found!"));
        Role role = roleOptional.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRole()));
        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(
            user.getUsername(), user.getPassword(), authorities);
        return userDetail;
    }

}