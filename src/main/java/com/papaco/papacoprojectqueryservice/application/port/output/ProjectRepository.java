package com.papaco.papacoprojectqueryservice.application.port.output;

import com.papaco.papacoprojectqueryservice.domain.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectRepository {
    Project save(Project project);

    Page<Project> findAll(Pageable page);

    Page<Project> findByOwnerId(Pageable page, Long ownerId);
}
