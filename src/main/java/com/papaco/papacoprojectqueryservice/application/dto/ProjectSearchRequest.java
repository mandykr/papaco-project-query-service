package com.papaco.papacoprojectqueryservice.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProjectSearchRequest {
    private List<Long> techStackIds;
}
