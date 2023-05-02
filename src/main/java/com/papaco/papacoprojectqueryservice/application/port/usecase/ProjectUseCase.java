package com.papaco.papacoprojectqueryservice.application.port.usecase;

import com.papaco.papacoprojectqueryservice.application.dto.ProjectDetailsResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectSearchRequest;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProjectUseCase {
    void updateProject(ProjectUpdateRequest request);

    Page<ProjectResponse> getProjects(Pageable page);

    Page<ProjectResponse> searchProjects(Pageable page, ProjectSearchRequest condition);

    Page<ProjectResponse> findProjectsByOwner(Pageable page, Long ownerId);

    ProjectDetailsResponse findProject(UUID projectId);
}
