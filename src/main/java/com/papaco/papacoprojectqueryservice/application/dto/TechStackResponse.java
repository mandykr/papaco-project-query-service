package com.papaco.papacoprojectqueryservice.application.dto;

import com.papaco.papacoprojectqueryservice.domain.entity.ProjectTechStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TechStackResponse {
    private Long id;
    private String name;

    public static List<String> getNames(List<ProjectTechStack> projectTechStacks) {
        return projectTechStacks.stream()
                .map(s -> s.getTechStack().getName())
                .toList();
    }
}
