package com.papaco.papacoprojectqueryservice.application.dto;

import com.papaco.papacoprojectqueryservice.domain.entity.Project;
import com.papaco.papacoprojectqueryservice.domain.entity.ProjectTechStack;

public class ProjectTechStackCreateRequest {
    private Long seq;
    private Project project;
    private TechStackCreateRequest techStack;

    public ProjectTechStack toProjectTechStack() {
        return new ProjectTechStack(seq, project, techStack.toTechStack());
    }
}
