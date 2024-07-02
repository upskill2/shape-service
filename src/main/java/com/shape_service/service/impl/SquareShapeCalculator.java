package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseShapeServiceRequest;
import com.shape_service.dao.request.SquareRequestShape;
import com.shape_service.service.ShapeCalculator;

public class SquareShapeCalculator implements ShapeCalculator {

    @Override
    public double calculateArea (final BaseShapeServiceRequest request) {
        final SquareRequestShape squareRequest = buildSquareAreaRequest (request);
        return squareRequest.getSquareSide () * squareRequest.getSquareSide ();
    }

    @Override
    public double calculatePerimeter (final BaseShapeServiceRequest request) {
        final SquareRequestShape squareRequest = buildSquareAreaRequest (request);
        return 4 * squareRequest.getSquareSide ();
    }

    private SquareRequestShape buildSquareAreaRequest (final BaseShapeServiceRequest request) {
        return SquareRequestShape
                .builder ()
                .squareSide (request.getSquareSide ())
                .build ();
    }

}
