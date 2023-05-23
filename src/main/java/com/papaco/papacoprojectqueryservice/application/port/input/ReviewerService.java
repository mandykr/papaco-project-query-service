package com.papaco.papacoprojectqueryservice.application.port.input;

import com.papaco.papacoprojectqueryservice.application.dto.ReviewerResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerReviewsResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerSearchRequest;
import com.papaco.papacoprojectqueryservice.application.port.output.ReviewerQueryRepository;
import com.papaco.papacoprojectqueryservice.application.port.usecase.ReviewerUseCase;
import com.papaco.papacoprojectqueryservice.domain.service.MateStatusSearchPolicy;
import com.papaco.papacoprojectqueryservice.domain.vo.MateStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewerService implements ReviewerUseCase {
    private final MateStatusSearchPolicy mateStatusSearchPolicy;
    private final ReviewerQueryRepository reviewerQueryRepository;

    @Override
    public Page<ReviewerResponse> searchReviewers(Pageable page, ReviewerSearchRequest condition) {
        List<MateStatus> statuses = mateStatusSearchPolicy.getSameStatusConditions(condition.getMateStatus());
        return reviewerQueryRepository.searchReviewers(page, condition, statuses);
    }

    @Override
    public ReviewerResponse getReviewer(Long id) {
        return reviewerQueryRepository.findById(id);
    }

    @Override
    public List<ReviewerReviewsResponse> getReviewerReviews(Long id) {
        return reviewerQueryRepository.findReviewsById(id);
    }
}
