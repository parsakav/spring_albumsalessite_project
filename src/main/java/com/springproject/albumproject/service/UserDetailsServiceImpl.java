package com.springproject.albumproject.service;


import com.springproject.albumproject.model.Role;
import com.springproject.albumproject.model.User;
import com.springproject.albumproject.repository.RoleRepository;
import com.springproject.albumproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);



        if(user==null) {
            throw  new UsernameNotFoundException(String.format("user name not found $s",username));
        }
        Set grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){

            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), grantedAuthorities);
    }
}