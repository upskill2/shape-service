package com.shape_service.controller;

import com.shape_service.dao.response.AreaServiceResponse;
import com.shape_service.dao.request.BaseAreaServiceRequest;
import com.shape_service.service.AreaCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class ShapeController {

    private final AreaCalculatorService service;

    @PostMapping ("/shape")
    public AreaServiceResponse calculate (@Valid @RequestBody BaseAreaServiceRequest request,
                                         @NotEmpty @RequestParam String shapeType) {

        final double area = service.calculateArea (request, shapeType);
        return AreaServiceResponse.builder ()
                .squareArea (area)
                .build ();
    }

}
