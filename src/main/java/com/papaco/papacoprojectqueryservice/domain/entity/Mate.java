package com.papaco.papacoprojectqueryservice.domain.entity;

import com.papaco.papacoprojectqueryservice.domain.vo.MateStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Mate {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "project_id",
            foreignKey = @ForeignKey(name = "fk_mate_to_project")
    )
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "reviewer_id",
            foreignKey = @ForeignKey(name = "fk_mate_to_reviewer")
    )
    private Reviewer reviewer;

    @Enumerated(EnumType.STRING)
    private MateStatus status;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
