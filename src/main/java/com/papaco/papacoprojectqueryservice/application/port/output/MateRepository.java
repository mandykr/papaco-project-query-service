package com.papaco.papacoprojectqueryservice.application.port.output;

import com.papaco.papacoprojectqueryservice.domain.entity.Mate;

import java.util.Optional;
import java.util.UUID;

public interface MateRepository {
    Optional<Mate> findReviewsByMateId(UUID mateId);
}
