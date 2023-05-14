package com.papaco.papacoprojectqueryservice.domain.entity;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
