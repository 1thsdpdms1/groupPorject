package org.spring.spring_board_0331.config;

import lombok.RequiredArgsConstructor;
import org.spring.spring_board_0331.entity.MemberEntity;
import org.spring.spring_board_0331.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
//    유저의 정보를 가져오는 인터페이스

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        MemberEntity memberEntity=memberRepository.findByUserEmail(userEmail).orElseThrow(()->{
            throw new IllegalArgumentException("회원이 없습니다");
        });
        return new UserDetailsImpl(memberEntity);
    }
}
