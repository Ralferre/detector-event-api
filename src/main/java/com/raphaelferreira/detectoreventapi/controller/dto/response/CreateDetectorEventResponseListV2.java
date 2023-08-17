package com.raphaelferreira.detectoreventapi.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CreateDetectorEventResponseListV2 {
    public static class Hystory {
        private String status;
        private String user;
        private String createdOn;

        public Hystory(String status, String user, String createdOn) {
            this.status = status;
            this.user = user;
            this.createdOn = createdOn;
        }

        public String getStatus() {
            return status;
        }

        public String getUser() {
            return user;
        }

        public String getCreatedOn() {
            return createdOn;
        }
    }
    private final String id;
    private final String name;
    @JsonProperty("reg_max")
    private final double regMax;
    @JsonProperty("created_on")
    private final String createdOn;
    private List<Hystory> hystory = new ArrayList<>();

    public CreateDetectorEventResponseListV2(String id, String name, double regMax, String createdOn, List<Hystory> hystory) {
        this.id = id;
        this.name = name;
        this.regMax = regMax;
        this.createdOn = createdOn;
        this.hystory = hystory;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @JsonProperty("reg_max")
    public double getRegMax() {
        return regMax;
    }
    @JsonProperty("created_on")
    public String getCreatedOn() {
        return createdOn;
    }

    public List<Hystory> getHystory() {
        return hystory;
    }


}
