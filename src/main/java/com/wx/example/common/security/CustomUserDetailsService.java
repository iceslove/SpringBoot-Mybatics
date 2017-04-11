package com.wx.example.common.security;

import com.wx.example.entity.Account;
import com.wx.example.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by wangxiong on 2017/3/21.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private AccountService accountService ;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = accountService.getAccountByName(accountName);

        log.info(account.getAccountName());
        log.info(account.getPassword());

        if (account == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", accountName));
        }
        return new CustomUserDetails(account);
    }

    private final static class CustomUserDetails extends Account implements UserDetails {

        private static final long serialVersionUID = 1L;
        private CustomUserDetails(Account account) {
            super(account);
        }

        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.createAuthorityList("ROLE_USER");
        }

        @Override
        public String getPassword() {
            return super.getPassword();
        }

        @Override
        public String getUsername() {
            return super.getAccountName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}
