package com.papaco.papacoprojectqueryservice.framework.adapter.output;

import com.papaco.papacoprojectqueryservice.application.dto.MateReviewResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewResponse;
import com.papaco.papacoprojectqueryservice.application.port.output.MateQueryRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.papaco.papacoprojectqueryservice.domain.entity.QMate.mate;
import static com.papaco.papacoprojectqueryservice.domain.entity.QProject.project;
import static com.papaco.papacoprojectqueryservice.domain.entity.QReview.review;
import static com.papaco.papacoprojectqueryservice.domain.entity.QReviewer.reviewer;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.querydsl.core.types.Projections.bean;

@RequiredArgsConstructor
@Repository
public class MateQuerydslRepository implements MateQueryRepository {
    private final JPAQueryFactory query;

    @Override
    public List<MateReviewResponse> findMatesByReviewerId(Long reviewerId) {
        return query
                .from(mate)
                .join(mate.project, project)
                .join(mate.reviewer, reviewer)
                .leftJoin(mate.reviews, review)
                .where(reviewerIdEq(reviewerId))
                .transform(groupBy(mate.id)
                        .list(bean(MateReviewResponse.class,
                                mate.id,
                                project.codeStore.name.as("projectName"),
                                reviewer.name.as("reviewerName"),
                                mate.status,
                                list(bean(ReviewResponse.class,
                                        review.id,
                                        review.status)
                                ).as("reviews")))
                );
    }

    private Predicate reviewerIdEq(Long reviewerId) {
        return reviewerId == null ? null : reviewer.id.eq(reviewerId);
    }
}
