package com.shape_service.controller;

import com.shape_service.dao.request.BaseShapeServiceRequest;
import com.shape_service.dao.response.ShapeServiceResponse;
import com.shape_service.service.ShapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class ShapeController {

    private final ShapeService service;

    @PostMapping (value = "/shape", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ShapeServiceResponse> calculate (@Valid @RequestBody BaseShapeServiceRequest request,
                                                           @NotEmpty @RequestParam String calculationType,
                                                           @NotEmpty @RequestParam String shapeType) {
        return ResponseEntity.ok (service.calculate (request, shapeType, calculationType));
    }

}
