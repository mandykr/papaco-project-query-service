package com.papaco.papacoprojectqueryservice.framework.adapter.input;

import com.papaco.papacoprojectqueryservice.application.dto.ProjectResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectSearchRequest;
import com.papaco.papacoprojectqueryservice.application.port.usecase.ProjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/projects")
@RestController
public class ProjectRestController {
    private final ProjectUseCase projectUseCase;

    @GetMapping
    public ResponseEntity<Page<ProjectResponse>> getProjects(@PageableDefault(size = 10, page = 0) Pageable page) {
        Page<ProjectResponse> projects = projectUseCase.getProjects(page);
        return ResponseEntity.ok().body(projects);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProjectResponse>> searchProjects(
            @PageableDefault(size = 10, page = 0) Pageable page,
            @RequestBody ProjectSearchRequest condition) {
        Page<ProjectResponse> projects = projectUseCase.searchProjects(page, condition);
        return ResponseEntity.ok().body(projects);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<Page<ProjectResponse>> findProjectsByOwner(
            @PageableDefault(size = 10, page = 0) Pageable page,
            @PathVariable Long ownerId) {
        Page<ProjectResponse> projects = projectUseCase.findProjectsByOwner(page, ownerId);
        return ResponseEntity.ok().body(projects);
    }
}
