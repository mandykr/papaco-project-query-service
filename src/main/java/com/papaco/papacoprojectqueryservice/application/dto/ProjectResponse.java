package com.papaco.papacoprojectqueryservice.application.dto;

import com.papaco.papacoprojectqueryservice.domain.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {
    private UUID id;
    private Long ownerId;
    private String codeStoreName;
    private String description;
    private List<String> techStacks;

    public static ProjectResponse of(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getOwnerId(),
                project.getCodeStore().getName(),
                project.getDescription(),
                TechStackResponse.getNames(project.getProjectTechStacks())
        );
    }

}
