package com.papaco.papacoprojectqueryservice.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TechStack {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    public TechStack(String name) {
        this.name = name;
    }
}
