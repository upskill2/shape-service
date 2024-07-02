package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseAreaServiceRequest;
import com.shape_service.dao.request.RectangleAreaRequest;
import com.shape_service.service.ShapeCalculatorService;

public class RectangleShapeCalculatorService implements ShapeCalculatorService {

    @Override
    public double calculateArea (final BaseAreaServiceRequest request) {
        RectangleAreaRequest rectangleRequest = RectangleAreaRequest
                .builder ()
                .length (request.getLength ())
                .width (request.getWidth ())
                .build ();
        return rectangleRequest.getLength () * rectangleRequest.getWidth ();
    }
}
