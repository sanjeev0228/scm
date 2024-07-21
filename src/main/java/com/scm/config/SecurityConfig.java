package com.scm.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scm.services.impl.SecurityCustomUserDetailService;

@Configuration
public class SecurityConfig {


//     //user create
//     @Bean
//     public UserDetailsService userDetailsService(){

        
// var inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//         return inMemoryUserDetailsManager;

//     }
 @Autowired
    private SecurityCustomUserDetailService userDetailService;



  @Bean
  public DaoAuthenticationProvider authenticationProvider() {

    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    // user detail service ka object:
    daoAuthenticationProvider.setUserDetailsService(userDetailService);
    // password encoder ka object
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

    return daoAuthenticationProvider;
}

  @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
