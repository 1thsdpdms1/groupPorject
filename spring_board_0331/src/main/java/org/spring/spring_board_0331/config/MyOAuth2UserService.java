package org.spring.spring_board_0331.config;

import lombok.NoArgsConstructor;
import org.spring.spring_board_0331.entity.MemberEntity;
import org.spring.spring_board_0331.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@NoArgsConstructor
public class MyOAuth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User=super.loadUser(userRequest);
        ClientRegistration clientRegistration=userRequest.getClientRegistration();//사용자 정보
        String clientId= clientRegistration.getClientId();//클라이언트 ID
        String registrationId=clientRegistration.getRegistrationId();// google,kakao,naver
        Map<String,Object> attributes=  oAuth2User.getAttributes();
        return oAuth2UserSucceses(oAuth2User,registrationId);
    }

    private OAuth2User oAuth2UserSucceses(OAuth2User oAuth2User, String registrationId) {
        String userEmail = ""; // 이메일 email
        String userName = "";   // 이름  name=kg s,
        String userPw = "";  // 암호화 -> 자동 생성

        if(registrationId.equals("google")){
            userEmail=oAuth2User.getAttribute("email");
            userName=oAuth2User.getAttribute("name");
        }
        Optional<MemberEntity>optionalMemberEntity=memberRepository.findByUserEmail(userEmail);
        if(optionalMemberEntity.isPresent()){
            //등록되어있으면
            
        }
    }
}
