package com.thuannd.erm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thuannd.erm.dao.UserDAO;
import com.thuannd.erm.dao.UserRoleDAO;
import com.thuannd.erm.entities.User;
import com.thuannd.erm.model.MyPrincipal;
import com.thuannd.erm.model.UserDTO;
import com.thuannd.erm.services.CommonService;
import com.thuannd.erm.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService, CommonService<UserDTO> {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userDAO.findByUsername(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User name not found!"));
        final User user = optionalUser.get();
        final List<String> roles = userRoleDAO.findAllRoleByUserId(user.getUserId());
        final List<GrantedAuthority> authorities = new ArrayList<>();
        if(!roles.isEmpty()){
            roles.forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            });
        }
        MyPrincipal accountDTO = null;
        if(Constants.STATUS_NEW.equals(user.getStatus())){
            accountDTO = new MyPrincipal(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
        } else{
            accountDTO = new MyPrincipal(user.getUsername(), user.getPassword(), false, true, true, true, authorities); 
        }
        accountDTO.setUserId(user.getUserId());
        accountDTO.setUserFullName(user.getFullname());
        return accountDTO;
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = new User();
        user.setFullname(userDTO.getFullName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setGender(userDTO.getGender());
        user.setStatus(userDTO.getStatus());
        userDAO.save(user);

        userDTO.setUserId(user.getUserId());
    }

    @Override
    public void update(UserDTO userDTO) {
        Optional<User> optionalUser = userDAO.findById(userDTO.getUserId());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setFullname(userDTO.getFullName());
            user.setUsername(userDTO.getUsername());
            user.setGender(userDTO.getGender());

            userDAO.save(user);
        }
    }

    @Override
    public void delete(UserDTO userDTO) {
        Optional<User> optionalUser = userDAO.findById(userDTO.getUserId());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            userDAO.delete(user);
        }
    }

    @Override
    public List<UserDTO> finAll() {
        List<User> users = userDAO.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        if(!users.isEmpty()){
            users.forEach(user ->{
                UserDTO userDTO = new UserDTO();
                userDTO.setFullName(user.getFullname());
                userDTO.setUsername(user.getUsername());
                userDTO.setPassword(user.getPassword());
                userDTO.setGender(user.getGender());
                userDTO.setStatus(user.getStatus());
            });
        }
        return userDTOs;
    }
    
}