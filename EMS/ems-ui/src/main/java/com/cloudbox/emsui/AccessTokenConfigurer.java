package com.cloudbox.emsui;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Collection;
import java.util.List;

public class AccessTokenConfigurer {

    public static String getToken(){

        OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();

        return oAuth2AuthenticationDetails.getTokenType().concat(" ").concat(oAuth2AuthenticationDetails.getTokenValue());
    }

    static String getPrincipalName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    static boolean getAuthorities(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"));
    }
}
