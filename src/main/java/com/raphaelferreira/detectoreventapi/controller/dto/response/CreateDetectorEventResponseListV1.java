package com.raphaelferreira.detectoreventapi.controller.dto.response;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateDetectorEventResponseListV1 {
    private final String id;
    private final String name;
    @JsonProperty("reg_max")
    private final double regMax;
    @JacksonInject("created_on")
    private final String createdOn;
    private final String status;
    private final String user;
    @JsonProperty("recognized_on")
    private final String recognizedOn;

    public CreateDetectorEventResponseListV1(
            String id,
            String name,
            double regMax,
            String createdOn,
            String status,
            String user,
            String recognizedOn) {
        this.id = id;
        this.name = name;
        this.regMax = regMax;
        this.createdOn = createdOn;
        this.status = status;
        this.user = user;
        this.recognizedOn = recognizedOn;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRegMax() {
        return regMax;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }

    public String getRecognizedOn() {
        return recognizedOn;
    }


}
