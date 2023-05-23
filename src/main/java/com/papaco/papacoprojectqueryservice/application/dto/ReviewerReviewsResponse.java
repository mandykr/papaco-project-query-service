package com.papaco.papacoprojectqueryservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewerReviewsResponse {
    private String projectName;
    private Long ownerId;
    private List<ReviewResponse> reviews;
}
