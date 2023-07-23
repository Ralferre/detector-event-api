package com.raphaelferreira.detectoreventapi.controller;

import com.raphaelferreira.detectoreventapi.controller.dto.request.DetectorEventRequest;
import com.raphaelferreira.detectoreventapi.controller.dto.response.DetectorEventResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetectorEventController {

    @PostMapping("/api/detection-events")
    public DetectorEventResponse createDetectorEvent(
            @Valid @RequestBody DetectorEventRequest detectorEventRequest
    ) {
        return new DetectorEventResponse(
                detectorEventRequest.getId(),
                detectorEventRequest.getName(),
                detectorEventRequest.getRegMax(),
                detectorEventRequest.getCreatedOn()
        );
    }

}
