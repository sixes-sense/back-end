package com.sixesSense.recorder.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuthService oAuthService;
//    private final OAuthSuccessHandler oAuthSuccessHandler;
//    private final OAuthFailureHandler oAuthFailureHandler;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                //CSRF- Cross Site Request Forgery : 사이트간 요청위조,
                // 쿠키 기반의 서버 세션 정보를 획득해야 공격할 수 있다.
                .csrf().disable() // 쿠키에 의존하지 않고 OAuth2.0, JWT를 사용하는 REST API 경우 CSRF 보호가 필요X
                .httpBasic().disable() // security 기본 로그인창 사용안함
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests() // 요청에 대한 인가 처리 설정
                .anyRequest().permitAll() // 모든 요청 허용
                //.antMatchers("/api/**", "/login/**", "/swagger-ui/**").permitAll()
                //.antMatchers("").hasRole(Role.USER.name())
                .and()
                //.logout()
                //.logoutSuccessUrl("/") //로그아웃 성공시 / 지점으로 이동
                //.and()
                .oauth2Login()
                //.successHandler()
                .userInfoEndpoint()// OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                .userService(oAuthService); //로그인 성공시 사용자 정보를 다루는 로직
//                .and()
//                .successHandler(oAuthSuccessHandler)
//                .failureHandler(oAuthFailureHandler);

//                .successHandler(oauth2SucessHandler)
//                .failureHandler(oAuth2FailurHandler)

        return http.build();
    }
}
