//package com.sixesSense.recorder.config.security;
//
//import com.sixesSense.recorder.config.JwtTokenUtil;
//import com.sixesSense.recorder.member.command.domain.aggregate.entity.Member;
//import com.sixesSense.recorder.member.command.domain.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.security.Key;
//import java.util.Optional;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class OAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    @Value("${jwt.token.secret")
//    private String key;
//
//    private final MemberRepository memberRepository;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//            throws IOException, ServletException {
//
//        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
//
//        String oauthId = oauth2User.getAttribute("id");
//        String email = oauth2User.getAttribute("email");
//
//        log.info("🤖 깃허브 OAuthId 추출 : [{}] || email 추출 : [{}]",oauthId,email);
//
//        Optional<Member> foundMember = memberRepository.findByOauthIdAndEmail(oauthId,email);
//        if(foundMember.isPresent()) {
//            String foundName = foundMember.get().getName();
//            log.info("🤖 소셜 로그인 인증한 사용자명 : [{}]", foundName);
//            String toekn = JwtTokenUtil.createToken(oauthId,email, key);
//            String refreshToken = JwtTokenUtil.createRe
//        }
//
//
//        String token = JwtTokenUtil.createToken(oauthId,email,key);
//
//
//
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}
