package com.raphaelferreira.detectoreventapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class UpdateDetectorEvent {
    private String status;
    @JsonProperty("user")
    private String userSystem;
    @JsonProperty("recognized_on")
    private LocalDateTime recognizedOn;

    public UpdateDetectorEvent() {}

    public LocalDateTime getRecognizedOn() {
        return recognizedOn = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public String getUserSystem() {
        return userSystem;
    }
}
