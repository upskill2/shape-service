package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseAreaServiceRequest;
import com.shape_service.dao.request.CircleAreaRequest;
import com.shape_service.service.ShapeCalculatorService;

public class CircleShapeCalculatorService implements ShapeCalculatorService {

    private static final double PI = 3.14159;

    @Override
    public double calculateArea (final BaseAreaServiceRequest request) {
        CircleAreaRequest circleRequest = CircleAreaRequest
                .builder ()
                .radius (request.getRadius ())
                .build ();
        return PI * circleRequest.getRadius () * circleRequest.getRadius ();
    }
}
