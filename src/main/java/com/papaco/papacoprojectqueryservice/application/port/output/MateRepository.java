package com.papaco.papacoprojectqueryservice.application.port.output;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewsResponse;
import com.papaco.papacoprojectqueryservice.domain.entity.Mate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MateRepository {
    Optional<Mate> findReviewsByMateId(UUID mateId);

    List<MateReviewsResponse> findMatesByReviewerId(Long reviewerId);
}
