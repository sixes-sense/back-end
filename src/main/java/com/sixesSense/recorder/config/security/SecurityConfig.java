package com.sixesSense.recorder.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    private final OAuthService oAuthService;

    public SecurityConfig(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable() // security 기본 로그인창 사용안함
                .csrf().disable() // html tag를 이용한 공격이지만 우리는 api서버를 이용하기에 disable
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests() // URL 별 권환 관리
                .antMatchers("/api/**").permitAll()
                //.antMatchers("").hasRole(Role.USER.name())
                .anyRequest().authenticated() // 설정값 이외 나머지것들은 인증된 사용자에게만 허용함
                .and()
                //.logout()
                //.logoutSuccessUrl("/") //로그아웃 성공시 / 지점으로 이동
                //.and()
                //.oauth2Login().loginPage("/login")
                //.and()
                .oauth2Login()
                    .userInfoEndpoint()// OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                    .userService(oAuthService); //로그인 성공시 후속 조치를 실행할 서비스로직
//                .and()
//                .successHandler()
        return http.build();
    }
}
