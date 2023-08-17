package com.raphaelferreira.detectoreventapi.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class UpdateDetectorEventRequest {
    @NotBlank(message = "user is mandatory")
    private final String user;
    @NotBlank(message = "registered on is mandatory")
    @JsonProperty("registered_on")
    private final String registeredOn;
    @NotBlank(message = "id is mandatory")
    private final String id;

    public UpdateDetectorEventRequest(String user, String registeredOn, String id) {
        this.user = user;
        this.registeredOn = registeredOn;
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public String getRegisteredOb() {
        return registeredOn;
    }

    public String getId() {
        return id;
    }

}
