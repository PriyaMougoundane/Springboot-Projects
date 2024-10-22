package com.blogpostapp.Config;


import com.blogpostapp.service.UserInfoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean

    //Authenication
    public UserDetailsService userDetailsService(){
/*
        UserDetails admin = User.withUsername("Eric")
                .password(encoder.encode("ericpass"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("Priya")
                .password(encoder.encode("priyapass"))
                .roles("USER")
                .build();


        return new InMemoryUserDetailsManager(admin,user);
*/
        return new UserInfoUserDetailsService();




    }
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        /*
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/api/Blog/showblogs","/User/addUser").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("api/Blog/showById")
                .authenticated().and().formLogin(formLogin -> formLogin.permitAll()).build()
                ;

         */
       return httpSecurity.csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(registry -> {
                   registry.requestMatchers("api/Blog/showblogs","/User/addUser").permitAll();
                   registry.requestMatchers("api/Blog/showById");
                   registry.anyRequest().authenticated();
               })
               .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
               .build();


    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

   @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;

    }
}
