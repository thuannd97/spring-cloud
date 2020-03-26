package com.thuannd.erm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thuannd.erm.dao.UserDAO;
import com.thuannd.erm.dao.UserRoleDAO;
import com.thuannd.erm.entities.Role;
import com.thuannd.erm.entities.User;
import com.thuannd.erm.model.MyPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDAO.findByUsername(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User name not found!"));
        User user = optionalUser.get();
        List<Role> roles = userRoleDAO.findAllRoleByUserId(user.getUserId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(!roles.isEmpty()){
            roles.forEach(role ->{
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            });
        }
        MyPrincipal accountDTO = new MyPrincipal(user.getUsername(), 
            user.getPassword(), , true, true, true, authorities);
        return accountDTO;
    }

}