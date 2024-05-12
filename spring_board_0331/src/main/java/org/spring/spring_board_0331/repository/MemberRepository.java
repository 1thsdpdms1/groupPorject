package org.spring.spring_board_0331.repository;

import org.spring.spring_board_0331.entity.BoardEntity;
import org.spring.spring_board_0331.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByUserEmail(String userEmail);
}
