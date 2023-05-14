package com.papaco.papacoprojectqueryservice.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ReviewerTechStack {
    @Column(name = "seq")
    @Id
    private Long seq;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "reviewer_id",
            foreignKey = @ForeignKey(name = "fk_reviewer_tech_stack_to_reviewer")
    )
    private Reviewer reviewer;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "techStack_id",
            foreignKey = @ForeignKey(name = "fk_reviewer_tech_stack_to_tech_stack")
    )
    private TechStack techStack;
}
