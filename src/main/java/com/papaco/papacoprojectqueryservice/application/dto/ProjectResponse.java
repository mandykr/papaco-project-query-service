package com.papaco.papacoprojectqueryservice.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ProjectResponse {
    private UUID id;
    private Long ownerId;
    private String ownerName;
    private String codeStoreId;
    private String codeStoreName;
//    private MateStatus mateStatus;
//    private Long reviewCount;
//    private List<String>
}
