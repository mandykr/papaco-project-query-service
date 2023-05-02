package com.papaco.papacoprojectqueryservice.framework.adapter.output;

import com.papaco.papacoprojectqueryservice.application.port.output.ProjectRepository;
import com.papaco.papacoprojectqueryservice.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectJpaRepository extends ProjectRepository, JpaRepository<Project, UUID> {
}
