package com.papaco.papacoprojectqueryservice.framework.adapter.input.aws;

import com.papaco.papacoprojectqueryservice.application.port.usecase.ProjectUseCase;
import com.papaco.papacoprojectqueryservice.framework.dto.ProjectBroadcastMessage;
import io.awspring.cloud.messaging.config.annotation.NotificationMessage;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProjectEventListener {
    private final ProjectUseCase projectUseCase;

    @SqsListener(value = "sqs-change-project-update-read-model-project.fifo", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void handleEvent(@NotificationMessage ProjectBroadcastMessage message) {
        log.info("listen from sqs-change-project-update-read-model-project.fifo: {}", message.getPayload());
        ProjectPayloadReader reader = new ProjectPayloadReader();
        projectUseCase.updateProject(reader.read(message.getPayload()));
    }
}
