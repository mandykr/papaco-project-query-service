package com.papaco.papacoprojectqueryservice.framework.adapter.output;

import com.papaco.papacoprojectqueryservice.application.dto.*;
import com.papaco.papacoprojectqueryservice.application.port.output.ProjectQueryRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.papaco.papacoprojectqueryservice.domain.entity.QMate.mate;
import static com.papaco.papacoprojectqueryservice.domain.entity.QProject.project;
import static com.papaco.papacoprojectqueryservice.domain.entity.QProjectTechStack.projectTechStack;
import static com.papaco.papacoprojectqueryservice.domain.entity.QReview.review;
import static com.papaco.papacoprojectqueryservice.domain.entity.QReviewer.reviewer;
import static com.papaco.papacoprojectqueryservice.domain.entity.QTechStack.techStack;
import static com.querydsl.core.group.GroupBy.*;
import static com.querydsl.core.types.Projections.bean;

@RequiredArgsConstructor
@Repository
public class ProjectQuerydslRepository implements ProjectQueryRepository {
    private final JPAQueryFactory query;

    @Override
    public Page<ProjectResponse> searchProjects(Pageable page, ProjectSearchRequest condition) {
        List<ProjectResponse> content = query
                .from(project)
                .leftJoin(project.projectTechStacks, projectTechStack)
                .join(projectTechStack.techStack, techStack)
                .where(techStacksAll(condition.getTechStackIds()))
                .offset(page.getOffset())
                .limit(page.getPageSize())
                .transform(groupBy(project.id)
                        .list(bean(ProjectResponse.class,
                                project.id,
                                project.ownerId,
                                project.codeStore.name.as("codeStoreName"),
                                project.description.description,
                                list(techStack.name).as("techStacks")))
                );

        JPAQuery<Long> countQuery = query
                .select(projectTechStack.countDistinct())
                .from(projectTechStack)
                .where(techStacksAll(condition.getTechStackIds()));

        return PageableExecutionUtils.getPage(content, page, countQuery::fetchOne);
    }

    private Predicate techStacksAll(List<Long> techStackIds) {
        if (techStackIds.isEmpty()) {
            return null;
        }

        List<UUID> projectIds = query
                .select(projectTechStack.project.id)
                .from(projectTechStack)
                .where(projectTechStack.techStack.id.in(techStackIds))
                .groupBy(projectTechStack.project.id)
                .having(projectTechStack.project.id.count()
                        .eq(Long.valueOf(techStackIds.size())))
                .fetch();
        return project.id.in(projectIds);
    }

    @Override
    public Optional<ProjectDetailsResponse> findById(UUID id) {
        return Optional.of(
                query
                        .from(project)
                        .leftJoin(project.projectTechStacks, projectTechStack)
                        .leftJoin(project.mates, mate)
                        .join(projectTechStack.techStack, techStack)
                        .where(projectIdEq(id))
                        .transform(groupBy(project.id)
                                .as(bean(ProjectDetailsResponse.class,
                                        project.id,
                                        project.ownerId,
                                        project.codeStore.name.as("codeStoreName"),
                                        project.description.description,
                                        set(techStack.name).as("techStacks"),
                                        list(bean(ProjectDetailsResponse.MateReviewResponse.class,
                                                mate.id,
                                                mate.reviewer.name.as("reviewerName"),
                                                mate.status
                                                )).as("mates")))
                        ).get(id));
    }

    private Predicate projectIdEq(UUID id) {
        return id != null ? project.id.eq(id) : null;
    }

    @Override
    public Page<ProjectReviewsResponse> findReviewsById(Pageable page, UUID id) {
        List<ProjectReviewsResponse> content = query
                .from(project)
                .leftJoin(project.mates, mate)
                .leftJoin(mate.reviewer, reviewer)
                .leftJoin(mate.reviews, review)
                .where(projectIdEq(id))
                .offset(page.getOffset())
                .limit(page.getPageSize())
                .transform(groupBy(mate.id)
                        .list(bean(ProjectReviewsResponse.class,
                                reviewer.name.as("reviewerName"),
                                mate.status,
                                list(bean(ReviewResponse.class,
                                        review.id,
                                        review.status)
                                ).as("reviews")))
                );

        JPAQuery<Long> countQuery = query
                .select(project.countDistinct())
                .from(project)
                .leftJoin(project.mates, mate)
                .where(projectIdEq(id));

        return PageableExecutionUtils.getPage(content, page, countQuery::fetchOne);
    }
}
