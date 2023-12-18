package com.raphaelferreira.detectoreventapi.controller;

import com.raphaelferreira.detectoreventapi.controller.dto.DetectorEvent;
import com.raphaelferreira.detectoreventapi.controller.dto.UpdateDetectorEvent;
import com.raphaelferreira.detectoreventapi.repository.DetectorEventRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DetectorEventController {
    private DetectorEventRepository detectorEventRepository;

    @Autowired
    public DetectorEventController(DetectorEventRepository detectorEventRepository) {
        this.detectorEventRepository = detectorEventRepository;
    }

    @GetMapping("/api/detection-insert")
    public String insertDetectorEvent() {
       DetectorEvent detectorEvent1 = new DetectorEvent("DT_001", "túnel congelamento empanados linha 01",31.2);
       detectorEvent1.setCreatedOn();
       detectorEventRepository.save(detectorEvent1);
       DetectorEvent detectorEvent2 = new DetectorEvent("DT_008","Mortadela",34.1);
       detectorEvent2.setCreatedOn();
       detectorEventRepository.save(detectorEvent2);
       DetectorEvent detectorEvent3 = new DetectorEvent("DT_007","Linguiça Calabresa",23.3);
       detectorEvent3.setCreatedOn();
       detectorEventRepository.save(detectorEvent3);
       DetectorEvent detectorEvent4 = new DetectorEvent("DT_006","Linguiça frescal",38.9);
       detectorEvent4.setCreatedOn();
       detectorEventRepository.save(detectorEvent4);
       DetectorEvent detectorEvent5 = new DetectorEvent("DT_005","Empanados",28.4);
       detectorEvent5.setCreatedOn();
       detectorEventRepository.save(detectorEvent5);

       return "Successful inserted!";
    }

    @PostMapping("/api/detection-events")
    public String detectorEventResponse(@Valid @RequestBody DetectorEvent detectorEvent) {
        new DetectorEvent(
                detectorEvent.getId(),
                detectorEvent.getName(),
                detectorEvent.getRegMax());
        detectorEvent.setCreatedOn();
        detectorEventRepository.save(detectorEvent);
        return "Successful inserted";
    }

    @DeleteMapping("/api/detection-events/{id}")
    public String deleteDetectorEvent(@PathVariable String id, DetectorEvent detectorEvent) {
        DetectorEvent detectorEvent1 = detectorEventRepository.findByCustomId(id);
        if (detectorEvent1 != null) {
            detectorEventRepository.delete(detectorEvent1);
            return "Detector event deleted successful!";
        } else {
            return "Detector event not found! Please, enter a valid id register.";
        }
    }

    @GetMapping("/api/detection-events/{id}")
    public DetectorEvent getDetectorEventById (@PathVariable String id) {
        DetectorEvent detectorEvent = detectorEventRepository.findByCustomId(id);
        if (detectorEvent != null) {
            return detectorEvent;
        } else {
            return null;
        }

    }

    @PutMapping("/api/detection-events/{id}")
    public String UpdateEventById(
            @PathVariable String id,
            @RequestBody UpdateDetectorEvent updateDetectorEvent) {

        DetectorEvent detectorEvent = detectorEventRepository.findByCustomId(id);
        detectorEvent.setStatus(updateDetectorEvent.getStatus());
        detectorEvent.setUserSystem(updateDetectorEvent.getUserSystem());
        detectorEvent.setRecognizedOn();
        detectorEvent.getRecognizedOn();

        detectorEventRepository.save(detectorEvent);

        return "Update done successful!";
    }

    List<DetectorEvent> detectorEventList = new ArrayList<>();
    @GetMapping("/api/detection-events")
    public List<DetectorEvent> getListDetectorEvents(
            @RequestParam(value = "id_start", required = false) String idStart,
            @RequestParam(value = "id_end", required = false) String idEnd,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "reg_max_start", required = false) Double regMaxStart,
            @RequestParam(value = "reg_max_end", required = false) Double regMaxEnd,
            @RequestParam(value = "created_on_start", required = false) String createdOnStart,
            @RequestParam(value = "created_on_end", required = false) String createdOnEnd) {

        if (idStart == null) idStart = "";
        if (idEnd == null) idEnd = "";
        if (name == null) name = "";
        if (regMaxStart == null) regMaxStart = 0.0;
        if (regMaxEnd == null) regMaxEnd = 0.0;
        if (createdOnStart == null) createdOnStart = "";
        if (createdOnEnd == null) createdOnEnd = "";

        return detectorEventRepository.findByIdAndNameAndRegMaxAndCreationDate(idStart,idEnd,name,regMaxStart,regMaxEnd,createdOnStart,createdOnEnd);

    }
}
