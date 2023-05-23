package com.papaco.papacoprojectqueryservice.application.port.output;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewsResponse;

import java.util.List;

public interface MateQueryRepository {
    List<MateReviewsResponse> findMatesByReviewerId(Long reviewerId);
}
