package com.papaco.papacoprojectqueryservice.framework.adapter.input;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewResponse;
import com.papaco.papacoprojectqueryservice.application.port.usecase.MateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/mates")
@RestController
public class MateRestController {
    private final MateUseCase mateUseCase;

    @GetMapping("/{mateId}/reviews")
    public ResponseEntity<MateReviewResponse> getMateReviews(@PathVariable UUID mateId) {
        MateReviewResponse reviews = mateUseCase.getReviews(mateId);
        return ResponseEntity.ok().body(reviews);
    }

    @GetMapping("/reviewers/{reviewerId}/reviews")
    public ResponseEntity<List<MateReviewResponse>> getMatesByReviewerId(@PathVariable Long reviewerId) {
        List<MateReviewResponse> mates = mateUseCase.getMatesByReviewerId(reviewerId);
        return ResponseEntity.ok().body(mates);
    }
}
