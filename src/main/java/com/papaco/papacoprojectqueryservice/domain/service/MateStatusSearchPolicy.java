package com.papaco.papacoprojectqueryservice.domain.service;

import com.papaco.papacoprojectqueryservice.domain.vo.MateStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.papaco.papacoprojectqueryservice.domain.vo.MateStatus.*;

@Service
public class MateStatusSearchPolicy {
    private final List<MateStatus> joinedStatuses;
    private final List<MateStatus> waitingStatuses;

    public MateStatusSearchPolicy() {
        joinedStatuses = Arrays.asList(JOINED);
        waitingStatuses = Arrays.asList(WAITING, PROPOSED, REJECTED, FINISHED);
    }

    public List<MateStatus> getSameStatusConditions(MateStatus status) {
        if (isJoinedStatus(status)) {
            return joinedStatuses;
        }
        return waitingStatuses;
    }

    private boolean isJoinedStatus(MateStatus status) {
        return joinedStatuses.contains(status);
    }
}
