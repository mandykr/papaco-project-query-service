package com.papaco.papacoprojectqueryservice.application.port.output;

import com.papaco.papacoprojectqueryservice.application.dto.ProjectResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectQueryRepository {
    Page<ProjectResponse> searchProjects(Pageable page, ProjectSearchRequest condition);
}
