package com.dox.cloud.storeauthserver.service;

import com.dox.cloud.storeauthserver.model.AuthUserDetail;
import com.dox.cloud.storeauthserver.model.User;
import com.dox.cloud.storeauthserver.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
    UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDetailRepository.findByUsername(s);

        optionalUser.orElseThrow(()->new UsernameNotFoundException("username or password wrong"));

        UserDetails userDetail = new AuthUserDetail(optionalUser.get());

        new AccountStatusUserDetailsChecker().check(userDetail);

        return userDetail;
    }
}
