package com.papaco.papacoprojectqueryservice.application.port.input;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewResponse;
import com.papaco.papacoprojectqueryservice.application.port.output.MateQueryRepository;
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
    private final MateQueryRepository mateQueryRepository;

    @Override
    public MateReviewResponse getReviews(UUID mateId) {
        return MateReviewResponse.of(mateRepository.findReviewsByMateId(mateId)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<MateReviewResponse> getMatesByReviewerId(Long reviewerId) {
        return mateQueryRepository.findMatesByReviewerId(reviewerId);
    }
}
