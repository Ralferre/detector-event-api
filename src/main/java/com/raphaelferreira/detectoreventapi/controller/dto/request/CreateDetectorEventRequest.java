package com.raphaelferreira.detectoreventapi.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDetectorEventRequest {
    @NotBlank(message = "id is mandatory")
    private final String id;

    @NotBlank(message = "name is mandatory")
    private final String name;

    @NotNull(message = "reg max is mandatory")
    @Max(100)
    @Min(0)
    @JsonProperty("reg_max")
    private final Double regMax;

    @NotBlank(message = "created on is mandatory")
    @JsonProperty("created_on")
    private final String createdOn;

    public CreateDetectorEventRequest(
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
