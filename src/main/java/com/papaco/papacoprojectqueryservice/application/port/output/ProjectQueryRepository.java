package com.papaco.papacoprojectqueryservice.application.port.output;

import com.papaco.papacoprojectqueryservice.application.dto.ProjectDetailsResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectReviewsResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ProjectQueryRepository {
    Page<ProjectResponse> searchProjects(Pageable page, ProjectSearchRequest condition);

    Optional<ProjectDetailsResponse> findById(UUID id);

    Page<ProjectReviewsResponse> findReviewsById(Pageable page, UUID id);
}
