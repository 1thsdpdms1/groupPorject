package org.spring.spring_board_0331.entity;

import lombok.*;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "member_tb1")
public class MemberEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String userName;

    @OneToMany(mappedBy = "memberEntity",fetch = FetchType.LAZY,
    cascade = CascadeType.REMOVE)
    private List<BoardEntity> boardEntityList;

//    @Enumerated(EnumType.STRING)
//    private Role role;
}
