package com.wx.example.common.security;

import com.wx.example.entity.Account;
import com.wx.example.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by wangxiong on 2017/4/1.
 */

@Service
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

    private static final String USER_NOT_FOUND_PASSWORD = "userNotFoundPassword";

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private AccountService accountService;
    private Md5PasswordEncoder md5PasswordEncoder =  new Md5PasswordEncoder();

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
        Account account = accountService.getAccountByName(userDetails.getUsername());
        if (account.getAccountLocked()==1) {
            throw new BadCredentialsException(messages.getMessage("account is locked","Bad account"));
        }
        String rawPass = authentication.getCredentials().toString();
        String encodePassword = DigestUtils.md5Hex(rawPass);

        boolean b = encodePassword.equals(userDetails.getPassword());
        if (!b) {
            logger.debug("Authentication failed: password does not match stored value");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        UserDetails loadedUser;

        try {
            loadedUser = this.getUserDetailsService().loadUserByUsername(username);
        } catch (UsernameNotFoundException notFound) {
            if(authentication.getCredentials() != null) {
                String presentedPassword = authentication.getCredentials().toString();
                String userNotFoundEncodedPassword = md5PasswordEncoder.encodePassword(USER_NOT_FOUND_PASSWORD, null);
                md5PasswordEncoder.isPasswordValid(userNotFoundEncodedPassword, presentedPassword, null);
            }
            throw notFound;
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException(
                    "UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

    protected UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }
}
