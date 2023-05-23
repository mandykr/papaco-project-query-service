package com.papaco.papacoprojectqueryservice.application.dto;

import com.papaco.papacoprojectqueryservice.domain.entity.Mate;
import com.papaco.papacoprojectqueryservice.domain.vo.MateStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MateReviewResponse {
    private UUID id;
    private String projectName;
    private String reviewerName;
    private MateStatus status;
    private List<ReviewResponse> reviews;

    public static MateReviewResponse of(Mate mate) {
        return new MateReviewResponse(
                mate.getId(),
                mate.getProject().getCodeStore().getName(),
                mate.getReviewer().getName(),
                mate.getStatus(),
                mate.getReviews().stream()
                        .map(ReviewResponse::of)
                        .toList()
        );
    }
}
