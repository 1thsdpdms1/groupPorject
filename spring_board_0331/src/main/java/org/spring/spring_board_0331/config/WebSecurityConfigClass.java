package org.spring.spring_board_0331.config;

import org.spring.spring_board_0331.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigClass {

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //웹페이지 설정
        http.authorizeHttpRequests()
                .antMatchers("/", "/member/join", "/member/login", "/board/boardList", "/board/detail").permitAll()
                .antMatchers("/css/**", "/images/**", "/js/**").permitAll()
                .antMatchers("/member/logout", "/board/write", "/member/memberList").authenticated()
                .antMatchers("/member/user/**").hasAnyRole("MEMBER", "ADMIN", "MANAGER")
                .antMatchers("/shop/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/admin/**").hasRole("ADMIN")
        ;
        http.formLogin()
                .loginPage("/member/login")
                .usernameParameter("userEmail")
                .passwordParameter("userPw")
                .loginProcessingUrl("/member/login")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/")
                //oAauth2로그인
                .and()
                .oauth2Login()
                .loginPage("/member/login")
                .userInfoEndpoint() //google정보
                .userService(myDefaultOAuth2UserService())
        ;
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/");


        return http.build();

    }

    @Bean
    private OAuth2UserService<OAuth2UserRequest, OAuth2User> myDefaultOAuth2UserService() {
        return new MyOAuth2UserService();
    }

}
