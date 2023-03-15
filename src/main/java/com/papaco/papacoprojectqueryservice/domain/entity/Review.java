package com.papaco.papacoprojectqueryservice.domain.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Review {
    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "mate_id",
            foreignKey = @ForeignKey(name = "fk_review_to_mate")
    )
    private Mate mate;
}
