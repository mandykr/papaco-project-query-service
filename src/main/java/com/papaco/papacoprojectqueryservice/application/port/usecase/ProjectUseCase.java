package com.papaco.papacoprojectqueryservice.application.port.usecase;

import com.papaco.papacoprojectqueryservice.application.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProjectUseCase {
    void updateProject(ProjectUpdateRequest request);

    Page<ProjectResponse> getProjects(Pageable page);

    Page<ProjectResponse> searchProjects(Pageable page, ProjectSearchRequest condition);

    Page<ProjectResponse> findProjectsByOwner(Pageable page, Long ownerId);

    ProjectDetailsResponse findProject(UUID projectId);

    Page<ProjectReviewsResponse> getProjectReviews(Pageable page, UUID projectId);
}
