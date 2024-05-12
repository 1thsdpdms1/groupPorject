package org.spring.spring_board_0331.dto;

import lombok.*;
import org.spring.spring_board_0331.entity.MemberEntity;

import javax.management.relation.Role;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class BoardDto {

    private Long id;

    private String nickName;

    private String title;

    private String content;

    private String boardPw;

    private int hit;

    private MemberEntity memberEntity;
}
