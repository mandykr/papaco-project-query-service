package com.papaco.papacoprojectqueryservice.application.port.input;

import com.papaco.papacoprojectqueryservice.application.dto.ProjectUpdateRequest;
import com.papaco.papacoprojectqueryservice.application.port.output.ProjectRepository;
import com.papaco.papacoprojectqueryservice.application.port.usecase.ProjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectService implements ProjectUseCase {
    private final ProjectRepository projectRepository;

    @Override
    public void updateProject(ProjectUpdateRequest request) {
        projectRepository.save(request.toProject());
    }
}
