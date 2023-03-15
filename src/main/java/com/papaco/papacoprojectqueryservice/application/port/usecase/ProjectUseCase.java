package com.papaco.papacoprojectqueryservice.application.port.usecase;

import com.papaco.papacoprojectqueryservice.application.dto.ProjectUpdateRequest;

public interface ProjectUseCase {
    void updateProject(ProjectUpdateRequest request);
}
