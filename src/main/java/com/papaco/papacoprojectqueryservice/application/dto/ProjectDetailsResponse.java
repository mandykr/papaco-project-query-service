package com.papaco.papacoprojectqueryservice.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ProjectDetailsResponse {
    private UUID id;
    private Long ownerId;
    private String codeStoreId;
    private String codeStoreName;
    private String projectDescription;
//    private MateStatus mateStatus;
//    private Long reviewCount;
}
