package com.papaco.papacoprojectqueryservice.application.dto;

import com.papaco.papacoprojectqueryservice.domain.entity.Project;
import com.papaco.papacoprojectqueryservice.domain.vo.CodeStore;
import com.papaco.papacoprojectqueryservice.domain.vo.ProjectDescription;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUpdateRequest {
    private UUID id;
    private Long ownerId;
    private String codeStoreId;
    private String codeStoreName;
    private String description;
    private List<ProjectTechStackCreateRequest> projectTechStacks;
    private boolean finished;
    private boolean deleted;

    public Project toProject() {
        return new Project(
                id,
                ownerId,
                new CodeStore(codeStoreId, codeStoreName),
                new ProjectDescription(description),
                projectTechStacks.stream().map(ProjectTechStackCreateRequest::toProjectTechStack).collect(Collectors.toList()),
                finished,
                deleted
        );
    }
}
