package org.spring.spring_board_0331.dto;

import lombok.*;
import org.spring.spring_board_0331.entity.BoardEntity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class MemberDto {

    private Long id;

    private String userEmail;

    private String userPw;

    private String userName;

    private Role role;

    private List<BoardEntity> boardEntityList;
}
