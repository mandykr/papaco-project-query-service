package com.papaco.papacoprojectqueryservice.application.dto;

import com.papaco.papacoprojectqueryservice.domain.vo.MateStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetailsResponse {
    private UUID id;
    private Long ownerId;
    private String codeStoreName;
    private String description;
    private Set<String> techStacks;
    private List<MateReviewResponse> mates;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MateReviewResponse {
        private UUID id;
        private String reviewerName;
        private MateStatus status;
    }
}
