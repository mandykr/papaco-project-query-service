package com.papaco.papacoprojectqueryservice.application.port.usecase;

import com.papaco.papacoprojectqueryservice.application.dto.ReviewerResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerReviewsResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewerUseCase {
    Page<ReviewerResponse> searchReviewers(Pageable page, ReviewerSearchRequest condition);

    ReviewerResponse getReviewer(Long id);

    List<ReviewerReviewsResponse> getReviewerReviews(Long id);
}
