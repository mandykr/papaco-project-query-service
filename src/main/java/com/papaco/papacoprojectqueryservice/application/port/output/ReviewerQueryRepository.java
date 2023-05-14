package com.papaco.papacoprojectqueryservice.application.port.output;

import com.papaco.papacoprojectqueryservice.application.dto.ReviewerResponse;
import com.papaco.papacoprojectqueryservice.application.dto.ReviewerSearchRequest;
import com.papaco.papacoprojectqueryservice.domain.vo.MateStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewerQueryRepository {
    Page<ReviewerResponse> searchReviewers(Pageable page, ReviewerSearchRequest condition, List<MateStatus> statuses);
}
