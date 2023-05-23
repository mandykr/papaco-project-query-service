package com.papaco.papacoprojectqueryservice.application.port.usecase;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewsResponse;

import java.util.List;
import java.util.UUID;

public interface MateUseCase {
    MateReviewsResponse getReviews(UUID mateId);

    List<MateReviewsResponse> findMatesByReviewerId(Long reviewerId);
}
