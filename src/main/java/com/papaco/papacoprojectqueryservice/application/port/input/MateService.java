package com.papaco.papacoprojectqueryservice.application.port.input;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewsResponse;
import com.papaco.papacoprojectqueryservice.application.port.output.MateRepository;
import com.papaco.papacoprojectqueryservice.application.port.usecase.MateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@Service
public class MateService implements MateUseCase {
    private final MateRepository mateRepository;

    @Override
    public MateReviewsResponse getReviews(UUID mateId) {
        return MateReviewsResponse.of(mateRepository.findReviewsByMateId(mateId)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<MateReviewsResponse> findMatesByReviewerId(Long reviewerId) {
        return mateRepository.findMatesByReviewerId(reviewerId);
    }
}
