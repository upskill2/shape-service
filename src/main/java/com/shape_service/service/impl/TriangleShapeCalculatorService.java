package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseAreaServiceRequest;
import com.shape_service.dao.request.TriangleAreaRequest;
import com.shape_service.service.ShapeCalculatorService;

public class TriangleShapeCalculatorService implements ShapeCalculatorService {


    @Override
    public double calculateArea (final BaseAreaServiceRequest request) {
        TriangleAreaRequest triangleRequest = TriangleAreaRequest
                .builder ()
                .base (request.getBase ())
                .height (request.getHeight ())
                .build ();
        return triangleRequest.getBase () * triangleRequest.getHeight () / 2;
    }

}
