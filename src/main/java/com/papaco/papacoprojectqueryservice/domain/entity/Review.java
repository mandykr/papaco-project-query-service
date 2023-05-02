package com.papaco.papacoprojectqueryservice.domain.entity;

import com.papaco.papacoprojectqueryservice.domain.vo.ReviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Review {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "mate_id",
            foreignKey = @ForeignKey(name = "fk_review_to_mate")
    )
    private Mate mate;

    @Enumerated(value = EnumType.STRING)
    private ReviewStatus status;
}
