package com.papaco.papacoprojectqueryservice.framework.adapter.input;

import com.papaco.papacoprojectqueryservice.application.dto.ReviewerResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerReviewsResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerSearchRequest;
import com.papaco.papacoprojectqueryservice.application.port.usecase.ReviewerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/reviewers")
@RestController
public class ReviewerRestController {
    private final ReviewerUseCase reviewerUseCase;

    @GetMapping("/search")
    public ResponseEntity<Page<ReviewerResponse>> searchReviewers(
            @PageableDefault(size = 10, page = 0) Pageable page,
            @RequestBody ReviewerSearchRequest condition) {
        Page<ReviewerResponse> reviewers = reviewerUseCase.searchReviewers(page, condition);
        return ResponseEntity.ok().body(reviewers);
    }

    @GetMapping("/{reviewerId}")
    public ResponseEntity<ReviewerResponse> getReviewer(@PathVariable Long reviewerId) {
        ReviewerResponse reviewer = reviewerUseCase.getReviewer(reviewerId);
        return ResponseEntity.ok().body(reviewer);
    }

    @GetMapping("/{reviewerId}/reviews")
    public ResponseEntity<List<ReviewerReviewsResponse>> getReviewerReviews(@PathVariable Long reviewerId) {
        List<ReviewerReviewsResponse> review = reviewerUseCase.getReviewerReviews(reviewerId);
        return ResponseEntity.ok().body(review);
    }
}
