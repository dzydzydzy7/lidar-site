package com.dzy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin();
        http.csrf().disable();
        // 只拦截LidarSet开头的URL
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/LidarSet/home").hasAnyAuthority("admin", "pager")
                .antMatchers("/LidarSet/people").hasAnyAuthority("admin", "pager")
                .antMatchers("/LidarSet/research").hasAnyAuthority("admin", "pager")
                .antMatchers("/LidarSet/project").hasAnyAuthority("admin", "pager")
                .antMatchers("/LidarSet/publications").hasAnyAuthority("admin", "pager")
                .antMatchers("/LidarSet/aboutUs").hasAnyAuthority("admin", "pager")
                .antMatchers("/LidarSet/settings/**").hasAnyAuthority("admin", "pager")
                .antMatchers("/LidarSet/others").hasAuthority("admin");
        // 使用默认的登录页面
        http.formLogin();
        // 使用spring security的登出
        http.logout().logoutSuccessUrl("/LidarLab/home");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        /*
         * BCryptPasswordEncoder：相同的密码明文每次生成的密文都不同，安全性更高
         */
        return new BCryptPasswordEncoder();
    }

}
