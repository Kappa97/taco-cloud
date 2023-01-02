package org.crystal.tacocloud.tacos.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    public SecurityConfiguration(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailsService();
//    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().requestMatchers(toH2Console()).permitAll()
//                        .and().csrf().ignoringRequestMatchers(toH2Console())
//                        .and().headers().frameOptions().sameOrigin();
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        {
                            try {

                                authorize
                                        //allow console path
                                        .requestMatchers(toH2Console()).permitAll()
                                        .requestMatchers("/register/**").permitAll()
                                        .requestMatchers("/").permitAll()
                                        //allow to see imahges in browser
                                        .requestMatchers("/images/**").permitAll()
                                        //.requestMatchers("/orders/**").permitAll()
                                        .requestMatchers("/login").permitAll()
                                        .requestMatchers("/index").authenticated()
                                        .requestMatchers("/design").authenticated()
                                        .requestMatchers("/orders/**").authenticated()
                                        //allow connect in console
                                        .and().headers().frameOptions().sameOrigin();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/design",true)
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    }

