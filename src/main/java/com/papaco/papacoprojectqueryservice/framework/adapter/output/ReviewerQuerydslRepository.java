package com.papaco.papacoprojectqueryservice.framework.adapter.output;

import com.papaco.papacoprojectqueryservice.application.dto.ReviewResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerReviewsResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerSearchRequest;
import com.papaco.papacoprojectqueryservice.application.port.output.ReviewerQueryRepository;
import com.papaco.papacoprojectqueryservice.domain.vo.MateStatus;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.papaco.papacoprojectqueryservice.domain.entity.QMate.mate;
import static com.papaco.papacoprojectqueryservice.domain.entity.QProject.project;
import static com.papaco.papacoprojectqueryservice.domain.entity.QReview.review;
import static com.papaco.papacoprojectqueryservice.domain.entity.QReviewer.reviewer;
import static com.papaco.papacoprojectqueryservice.domain.entity.QReviewerTechStack.reviewerTechStack;
import static com.papaco.papacoprojectqueryservice.domain.entity.QTechStack.techStack;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.querydsl.core.types.Projections.bean;

@RequiredArgsConstructor
@Repository
public class ReviewerQuerydslRepository implements ReviewerQueryRepository {
    private final JPAQueryFactory query;

    @Override
    public Page<ReviewerResponse> searchReviewers(Pageable page, ReviewerSearchRequest condition, List<MateStatus> statuses) {
        List<ReviewerResponse> content = query
                .from(mate)
                .rightJoin(mate.reviewer, reviewer)
                .leftJoin(reviewer.reviewerTechStacks, reviewerTechStack)
                .join(reviewerTechStack.techStack, techStack)
                .where(
                        lastModifiedMates(),
                        techStacksAll(condition.getTechStackIds()),
                        mateStatusIn(statuses)
                )
                .offset(page.getOffset())
                .limit(page.getPageSize())
                .transform(groupBy(reviewer.id)
                        .list(bean(ReviewerResponse.class,
                                reviewer.id,
                                reviewer.name,
                                mate.status,
                                list(techStack.name).as("techStacks")))
                );

        JPAQuery<Long> countQuery = query
                .select(reviewerTechStack.countDistinct())
                .from(mate)
                .rightJoin(mate.reviewer, reviewer)
                .leftJoin(reviewer.reviewerTechStacks, reviewerTechStack)
                .join(reviewerTechStack.techStack, techStack)
                .where(
                        lastModifiedMates(),
                        techStacksAll(condition.getTechStackIds()),
                        mateStatusIn(statuses)
                );

        return PageableExecutionUtils.getPage(content, page, countQuery::fetchOne);
    }

    private BooleanExpression lastModifiedMates() {
        return Expressions.list(reviewer.id, mate.modifiedDate).in(
                JPAExpressions.select(mate.reviewer.id, mate.modifiedDate.max())
                        .from(mate)
                        .groupBy(mate.reviewer.id));
    }

    private Predicate techStacksAll(List<Long> techStackIds) {
        if (techStackIds.isEmpty()) {
            return null;
        }

        List<Long> reviewerIds = query
                .select(reviewerTechStack.reviewer.id)
                .from(reviewerTechStack)
                .where(reviewerTechStack.techStack.id.in(techStackIds))
                .groupBy(reviewerTechStack.reviewer.id)
                .having(reviewerTechStack.reviewer.id.count()
                        .eq(Long.valueOf(techStackIds.size())))
                .fetch();
        return reviewer.id.in(reviewerIds);
    }

    private Predicate mateStatusIn(List<MateStatus> statuses) {
        return statuses.isEmpty() ? null : mate.status.in(statuses);
    }

    @Override
    public ReviewerResponse findById(Long id) {
        return query
                .from(mate)
                .rightJoin(mate.reviewer, reviewer)
                .leftJoin(reviewer.reviewerTechStacks, reviewerTechStack)
                .join(reviewerTechStack.techStack, techStack)
                .where(
                        lastModifiedMates(),
                        reviewerIdEq(id)
                )
                .transform(groupBy(reviewer.id)
                        .list(bean(ReviewerResponse.class,
                                reviewer.id,
                                reviewer.name,
                                mate.status,
                                list(techStack.name).as("techStacks")))
                ).get(0);
    }

    @Override
    public List<ReviewerReviewsResponse> findReviewsById(Long id) {
        return query
                .from(mate)
                .rightJoin(mate.reviewer, reviewer)
                .rightJoin(mate.project, project)
                .leftJoin(mate.reviews, review)
                .where(
                        reviewerIdEq(id)
                )
                .transform(groupBy(mate.id)
                        .list(bean(ReviewerReviewsResponse.class,
                                project.codeStore.name.as("projectName"),
                                project.ownerId,
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
