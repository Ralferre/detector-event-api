package com.raphaelferreira.detectoreventapi.controller;

import com.raphaelferreira.detectoreventapi.controller.dto.request.CreateDetectorEventRequest;
import com.raphaelferreira.detectoreventapi.controller.dto.request.UpdateDetectorEventRequest;
import com.raphaelferreira.detectoreventapi.controller.dto.response.CreateDetectorEventResponse;
import com.raphaelferreira.detectoreventapi.controller.dto.response.CreateDetectorEventResponseListV1;
import com.raphaelferreira.detectoreventapi.controller.dto.response.CreateDetectorEventResponseListV2;
import com.raphaelferreira.detectoreventapi.controller.dto.response.UpdateDetectorEventResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DetectorEventController {

    @PostMapping("/api/detection-events")
    public CreateDetectorEventResponse createDetectorEvent(
            @Valid @RequestBody CreateDetectorEventRequest createDetectorEventRequest
    ) {
        return new CreateDetectorEventResponse(
                createDetectorEventRequest.getId(),
                createDetectorEventRequest.getName(),
                createDetectorEventRequest.getRegMax(),
                createDetectorEventRequest.getCreatedOn()
        );
    }

    @DeleteMapping("/api/detection-events/{id}")
    public void deleteDetectorEvent(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping("/api/detection-events/{id}")
    public CreateDetectorEventResponse getDetectorEventById(@PathVariable String id) {
        return new CreateDetectorEventResponse(
                "DT_004",
                "Estufa resfriamento de presunto",
                55.0,
                "14-08-2023 02:47:33"
        );
    }

    @PutMapping("/api/detection-events/{id}")
    public UpdateDetectorEventResponse updateDetectorEventById(
            @PathVariable String id,
            @RequestBody UpdateDetectorEventRequest updateDetectorEventRequest
    ) {
        return new UpdateDetectorEventResponse(
                "Algodão",
                "2023-07-23",
                "Sabão em Pó"
        );
    }

    List<CreateDetectorEventResponseListV1> detectorEventResponseListV1List = new ArrayList<>();
    @GetMapping("/api/detection-events")
    public List<CreateDetectorEventResponseListV1> getDetectorEventResponseV1List(
            @RequestParam(value = "id_start", required = false) String idStart,
            @RequestParam(value = "id_end", required = false) String idEnd,
            @RequestParam(value = "name_start", required = false) String nameStart,
            @RequestParam(value = "name_end", required = false) String nameEnd,
            @RequestParam(value = "reg_max_start", required = false) double regMaxStart,
            @RequestParam(value = "reg_max_end", required = false) double regMaxEnd,
            @RequestParam(value = "created_on_start", required = false) String createdOnStart,
            @RequestParam(value = "created_on_end", required = false) String createdOnEnd) {

        List<CreateDetectorEventResponseListV1> filteredEventsResponseV1List = detectorEventResponseListV1List.stream().
                filter(detectorEventResponse ->
                        (idStart == null || detectorEventResponse.getId().equals(idStart)) ||
                        (idEnd == null || detectorEventResponse.getId().equals(idEnd)) ||
                        (nameStart == null || detectorEventResponse.getName().compareToIgnoreCase(nameStart) >= 0) ||
                        (nameEnd == null || detectorEventResponse.getName().compareToIgnoreCase(nameEnd) <= 0) ||
                        (regMaxStart >= detectorEventResponse.getRegMax()) ||
                        (regMaxEnd <= detectorEventResponse.getRegMax()) ||
                        (createdOnStart == null || detectorEventResponse.getCreatedOn().equals(createdOnStart)) ||
                        (createdOnEnd == null || detectorEventResponse.getCreatedOn().equals(createdOnEnd)))
                .collect(Collectors.toList());

        List<String> parametersValuesV1 = new ArrayList<>();
        if (idStart != null) {
            parametersValuesV1.add("id_start=" + idStart);
        }
        if (idEnd != null) {
            parametersValuesV1.add("id_end=" + idEnd);
        }
        if (nameStart != null) {
            parametersValuesV1.add("name_start=" + nameStart);
        }
        if (nameEnd != null) {
            parametersValuesV1.add("name_end=" + nameEnd);
        }
        if (regMaxStart != 0) {
            parametersValuesV1.add("reg_max_start=" + regMaxStart);
        }
        if (regMaxEnd != 0) {
            parametersValuesV1.add("reg_max_end=" + regMaxEnd);
        }
        if (idStart != null) {
            parametersValuesV1.add("created_on_start=" + createdOnStart);
        }
        if (createdOnEnd != null) {
            parametersValuesV1.add("created_on_end=" + createdOnEnd);
        }

        System.out.println("Parameters values V1: " + parametersValuesV1);
        List<CreateDetectorEventResponseListV1> myMockedList = new ArrayList<>();

        myMockedList.add(new CreateDetectorEventResponseListV1(
                "DT_001",
                "Túnel congelamento empanados linha 01",
                22.4,
                "15-08-2023 02:03:02",
                "MUTED",
                "Raphael",
                "15-08-2023 02:38:48"));
        myMockedList.add(new CreateDetectorEventResponseListV1(
                "DT_002",
                "Túnel congelamento empanados linha 02",
                30.9,
                "03-08-2023 05:45:28",
                "REARMED",
                "Renan",
                "03-08-2023 06:20:06"));
        return myMockedList;

    }

    List<CreateDetectorEventResponseListV2> detectorEventResponseListV2List = new ArrayList<>();
    @GetMapping("/api/detection-events/")
    public List<CreateDetectorEventResponseListV2> getDetectorEventResponseV2List(
            @RequestParam(value = "id_start", required = false) String idStart,
            @RequestParam(value = "id_end", required = false) String idEnd,
            @RequestParam(value = "name_start", required = false) String nameStart,
            @RequestParam(value = "name_end", required = false) String nameEnd,
            @RequestParam(value = "reg_max_start", required = false) Double regMaxStart,
            @RequestParam(value = "reg_max_end", required = false) Double regMaxEnd,
            @RequestParam(value = "created_on_start", required = false) String createdOnStart,
            @RequestParam(value = "created_on_end", required = false) String createdOnEnd) {

        List<CreateDetectorEventResponseListV2> filteredEventsResponseV2List = detectorEventResponseListV2List.stream().
                filter(detectorEventResponse ->
                        (idStart == null || detectorEventResponse.getId().equals(idStart)) ||
                                (idEnd == null || detectorEventResponse.getId().equals(idEnd)) ||
                                (nameStart == null || detectorEventResponse.getName().compareToIgnoreCase(nameStart) >= 0) ||
                                (nameEnd == null || detectorEventResponse.getName().compareToIgnoreCase(nameEnd) <= 0) ||
                                (regMaxStart >= detectorEventResponse.getRegMax()) ||
                                (regMaxEnd <= detectorEventResponse.getRegMax()) ||
                                (createdOnStart == null || detectorEventResponse.getCreatedOn().equals(createdOnStart)) ||
                                (createdOnEnd == null || detectorEventResponse.getCreatedOn().equals(createdOnEnd)))
                .collect(Collectors.toList());

        List<String> parametersValuesV2 = new ArrayList<>();
        if (idStart != null) {
            parametersValuesV2.add("id_start=" + idStart);
        }
        if (idEnd != null) {
            parametersValuesV2.add("id_end=" + idEnd);
        }
        if (nameStart != null) {
            parametersValuesV2.add("name_start=" + nameStart);
        }
        if (nameEnd != null) {
            parametersValuesV2.add("name_end=" + nameEnd);
        }
        if (regMaxStart != null) {
            parametersValuesV2.add("reg_max_start=" + regMaxStart);
        }
        if (regMaxEnd != null) {
            parametersValuesV2.add("reg_max_end=" + regMaxEnd);
        }
        if (idStart != null) {
            parametersValuesV2.add("created_on_start=" + createdOnStart);
        }
        if (createdOnEnd != null) {
            parametersValuesV2.add("created_on_end=" + createdOnEnd);
        }

        System.out.println("Parameters values V2: " + parametersValuesV2);

        List<CreateDetectorEventResponseListV2> myMockedList = new ArrayList<>();
        List<CreateDetectorEventResponseListV2.Hystory> hystories = new ArrayList<>();
        hystories.add(new CreateDetectorEventResponseListV2.Hystory(
                "REARMED",
                "Raphael",
                "15-08-2023 02:57:26"));

        List<CreateDetectorEventResponseListV2.Hystory> hystories1 = new ArrayList<>();
        hystories1.add(new CreateDetectorEventResponseListV2.Hystory(
                "MUTED",
                "Raphael",
                "03-08-2023 04:36:26"));

        myMockedList.add(new CreateDetectorEventResponseListV2(
                "DT_001",
                "Túnel congelamento empanados linha 01",
                22.4,
                "15-08-2023 02:03:02",
                hystories));
        myMockedList.add(new CreateDetectorEventResponseListV2(
                "DT_002",
                "Túnel congelamento empanados linha 02",
                30.9,
                "03-08-2023 05:45:28",
                hystories1));
        return myMockedList;
    }
}
