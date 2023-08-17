package com.raphaelferreira.detectoreventapi.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateDetectorEventResponse {
    private final String id;
    private final String name;
    @JsonProperty("reg_max")
    private final Double regMax;

    @JsonProperty("created_on")
    private final String createdOn;

    public CreateDetectorEventResponse(
            String id,
            String name,
            Double regMax,
            String createdOn
    ) {
        this.id = id;
        this.name = name;
        this.regMax = regMax;
        this.createdOn = createdOn;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getRegMax() {
        return regMax;
    }

    public String getCreatedOn() {
        return createdOn;
    }
}
