package org.spring.spring_board_0331.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.spring.spring_board_0331.entity.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private MemberEntity memberEntity;

    //일반회원관리///////////////////////////
    public UserDetailsImpl(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }
    /////////////////////////////////


    //일반회원 오버라이드
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return memberEntity.getUserPw();
    }

    @Override
    public String getUsername() {
        return memberEntity.getUserEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
