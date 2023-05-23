package com.papaco.papacoprojectqueryservice.application.port.usecase;

import com.papaco.papacoprojectqueryservice.application.dto.ReviewerResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewerUseCase {
    Page<ReviewerResponse> searchReviewers(Pageable page, ReviewerSearchRequest condition);

    ReviewerResponse getReviewer(Long reviewerId);
}
