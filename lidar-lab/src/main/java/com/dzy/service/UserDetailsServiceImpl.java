package com.dzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("UserDetailsService没有接收到用户账号");
        } else {
            com.dzy.pojo.User u = userService.getUserByUserName(username);
            if (u == null) {
                throw  new UsernameNotFoundException(String.format("用户'%s'不存在", username));
            }
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("admin"));
            return new User(u.getUserName(), u.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        }
    }
}
