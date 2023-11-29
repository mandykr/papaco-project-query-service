package com.papaco.papacoprojectqueryservice.framework.adapter.output;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewsResponse;

import java.util.List;

public interface MateQueryRepository {
    List<MateReviewsResponse> findMatesByReviewerId(Long reviewerId);
}
