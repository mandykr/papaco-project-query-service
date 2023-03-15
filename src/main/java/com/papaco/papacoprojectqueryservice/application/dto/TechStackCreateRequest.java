package com.papaco.papacoprojectqueryservice.application.dto;

import com.papaco.papacoprojectqueryservice.domain.entity.TechStack;

public class TechStackCreateRequest {
    private Long id;
    private String name;

    public TechStack toTechStack() {
        return new TechStack(id, name);
    }
}
