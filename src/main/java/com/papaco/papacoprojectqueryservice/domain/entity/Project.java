package com.papaco.papacoprojectqueryservice.domain.entity;

import com.papaco.papacoprojectqueryservice.domain.vo.CodeStore;
import com.papaco.papacoprojectqueryservice.domain.vo.ProjectDescription;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Where(clause = "deleted = false")
@Entity
public class Project {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;
    private Long ownerId;

    @Embedded
    private CodeStore codeStore;

    @Embedded
    private ProjectDescription description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectTechStack> projectTechStacks = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mate> mates = new ArrayList<>();

    private boolean finished = Boolean.FALSE;
    private boolean deleted = Boolean.FALSE;

    public Project(UUID id, Long ownerId, CodeStore codeStore, ProjectDescription description, List<ProjectTechStack> projectTechStacks, boolean finished, boolean deleted) {
        this(id, ownerId, codeStore, description, projectTechStacks, Collections.emptyList(), finished, deleted);
    }

    public UUID getId() {
        return id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public CodeStore getCodeStore() {
        return codeStore;
    }

    public String getDescription() {
        return description.getDescription();
    }

    public List<ProjectTechStack> getProjectTechStacks() {
        return projectTechStacks;
    }

    public List<Mate> getMates() {
        return mates;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
