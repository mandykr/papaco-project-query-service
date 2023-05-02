package com.papaco.papacoprojectqueryservice.application.dto;

import com.papaco.papacoprojectqueryservice.domain.entity.Review;
import com.papaco.papacoprojectqueryservice.domain.vo.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private UUID id;
    private ReviewStatus status;

    public static ReviewResponse of(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getStatus()
        );
    }
}
