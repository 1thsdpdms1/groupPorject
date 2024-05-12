package org.spring.spring_board_0331.repository;

import org.spring.spring_board_0331.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
