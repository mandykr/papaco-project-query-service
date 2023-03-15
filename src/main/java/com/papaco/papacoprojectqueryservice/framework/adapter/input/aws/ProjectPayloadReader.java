package com.papaco.papacoprojectqueryservice.framework.adapter.input.aws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaco.papacoprojectqueryservice.application.dto.ProjectUpdateRequest;

public class ProjectPayloadReader {
    public ProjectUpdateRequest read(String payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(payload, ProjectUpdateRequest.class);
        } catch (JsonProcessingException e) {
            throw new ProjectPayloadReadException(e);
        }
    }
}
