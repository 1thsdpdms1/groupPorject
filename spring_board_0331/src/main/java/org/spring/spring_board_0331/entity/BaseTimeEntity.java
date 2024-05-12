package org.spring.spring_board_0331.entity;

import lombok.Getter;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(value = AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime CreateTime;

    @CreationTimestamp
    @Column(insertable = false)
    private LocalDateTime updateTime;
}
