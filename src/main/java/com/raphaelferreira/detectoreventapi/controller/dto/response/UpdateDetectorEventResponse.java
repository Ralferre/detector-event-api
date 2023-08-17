package com.raphaelferreira.detectoreventapi.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class UpdateDetectorEventResponse {
    @NotBlank(message = "user is mandatory")
    private final String user;
    @JsonProperty("registered_on")
    private final String registeredOn;
    @NotBlank(message = "id is mandatory")
    private final String id;

    public UpdateDetectorEventResponse(
            String user,
            String registeredOn,
            String id
    ) {
        this.user = user;
        this.registeredOn = registeredOn;
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public String getId() {
        return id;
    }
}
