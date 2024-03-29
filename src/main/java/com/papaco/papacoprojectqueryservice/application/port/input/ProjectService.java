package com.papaco.papacoprojectqueryservice.application.port.input;

import com.papaco.papacoprojectqueryservice.application.dto.*;
import com.papaco.papacoprojectqueryservice.application.port.output.ProjectRepository;
import com.papaco.papacoprojectqueryservice.application.port.usecase.ProjectUseCase;
import com.papaco.papacoprojectqueryservice.application.port.output.ProjectQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Transactional
@RequiredArgsConstructor
@Service
public class ProjectService implements ProjectUseCase {
    private final ProjectRepository projectRepository;
    private final ProjectQueryRepository projectQueryRepository;

    @Override
    public void updateProject(ProjectUpdateRequest request) {
        projectRepository.save(request.toProject());
    }

    @Override
    public Page<ProjectResponse> getProjects(Pageable page) {
        return projectRepository.findAll(page)
                .map(ProjectResponse::of);
    }

    @Override
    public Page<ProjectResponse> searchProjects(Pageable page, ProjectSearchRequest condition) {
        return projectQueryRepository.searchProjects(page, condition);
    }

    @Override
    public Page<ProjectResponse> findProjectsByOwner(Pageable page, Long ownerId) {
        return projectRepository.findByOwnerId(page, ownerId)
                .map(ProjectResponse::of);
    }

    @Override
    public ProjectDetailsResponse findProject(UUID projectId) {
        return projectQueryRepository.findById(projectId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<ProjectReviewsResponse> getProjectReviews(Pageable page, UUID projectId) {
        return projectQueryRepository.findReviewsById(page, projectId);
    }
}
