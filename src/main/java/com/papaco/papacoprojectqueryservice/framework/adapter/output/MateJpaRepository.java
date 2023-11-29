package com.papaco.papacoprojectqueryservice.framework.adapter.output;

import com.papaco.papacoprojectqueryservice.application.port.output.MateRepository;
import com.papaco.papacoprojectqueryservice.domain.entity.Mate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface MateJpaRepository extends MateRepository, MateQueryRepository, JpaRepository<Mate, UUID> {

    @Override
    @Query("select m" +
            " from Mate m" +
            " join fetch m.project p" +
            " join fetch m.reviewer r" +
            " left join fetch m.reviews s" +
            " where m.id = :mateId")
    Optional<Mate> findReviewsByMateId(UUID mateId);
}
