package com.papaco.papacoprojectqueryservice.application.port.output;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewResponse;

import java.util.List;

public interface MateQueryRepository {
    List<MateReviewResponse> findMatesByReviewerId(Long reviewerId);
}
