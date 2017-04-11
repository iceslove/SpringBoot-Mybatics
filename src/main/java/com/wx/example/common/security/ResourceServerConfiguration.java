package com.wx.example.common.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 配置授权资源路径
 * Created by wangxiong on 2017/3/21.
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/api/**").authorizeRequests().anyRequest().authenticated();

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/token").permitAll()
                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll();
    }
}
