package com.raphaelferreira.detectoreventapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class DetectorEvent {
    @Id
    @NotBlank(message = "id is mandatory")
    private String id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotNull(message = "reg max is mandatory")
    @Max(100)
    @Min(0)
    @JsonProperty("reg_max")
    private Double regMax;

    @JsonProperty("created_on")
    private String createdOn;

    private String status;
    @JsonProperty("user")
    private String userSystem;
    @JsonProperty("recognized_on")
    private String recognizedOn;

    public void setCreatedOn() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.createdOn = localDateTime.format(dateTimeFormatter);
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setRecognizedOn() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.recognizedOn = localDateTime.format(dateTimeFormatter);
    }

    public String getRecognizedOn() {
        return recognizedOn;
    }

    public DetectorEvent() {}
    public DetectorEvent(
            String id,
            String name,
            Double regMax
    ) {
        this.id = id;
        this.name = name;
        this.regMax = regMax;
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

    public void setStatus(String status) {
        if (status.equals("MUTED") || status.equals("REARMED") || status.equals("WARNING")) {
            this.status = status;
        } else {
            System.out.println("Invalid insertion!");
        }

    }

    public void setUserSystem(String userSystem) {
        this.userSystem = userSystem;
    }
}
