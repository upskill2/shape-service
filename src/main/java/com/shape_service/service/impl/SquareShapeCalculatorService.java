package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseAreaServiceRequest;
import com.shape_service.dao.request.SquareAreaRequest;
import com.shape_service.service.ShapeCalculatorService;

public class SquareShapeCalculatorService implements ShapeCalculatorService {

    @Override
    public double calculateArea (final BaseAreaServiceRequest request) {
        SquareAreaRequest squareRequest = SquareAreaRequest
                .builder ()
                .side (request.getSide ())
                .build ();
        return squareRequest.getSide () * squareRequest.getSide ();
    }
}
