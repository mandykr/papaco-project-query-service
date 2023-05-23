package com.papaco.papacoprojectqueryservice.application.port.usecase;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewResponse;

import java.util.List;
import java.util.UUID;

public interface MateUseCase {
    MateReviewResponse getReviews(UUID mateId);

    List<MateReviewResponse> getMatesByReviewerId(Long reviewerId);
}
