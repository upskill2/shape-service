package com.shape.service.service.impl;

import com.shape.service.dao.request.SquareRequestShape;
import com.shape.service.dao.request.BaseShapeServiceRequest;
import com.shape.service.service.ShapeCalculator;

import static com.shape.service.util.Utils.checkFieldPresent;
import static com.shape.service.util.Utils.getDouble;

public class SquareShapeCalculator implements ShapeCalculator {

    public static final String SQUARE_SIDE = "Square side";

    @Override
    public double calculateArea (final BaseShapeServiceRequest request) {
        final SquareRequestShape squareRequest = buildSquareAreaRequest (request);
        return getDouble (squareRequest.getSquareSide (), SQUARE_SIDE) * getDouble (squareRequest.getSquareSide (), SQUARE_SIDE);
    }

    @Override
    public double calculatePerimeter (final BaseShapeServiceRequest request) {
        final SquareRequestShape squareRequest = buildSquareAreaRequest (request);
        return 4 * getDouble (squareRequest.getSquareSide (), SQUARE_SIDE);
    }

    private SquareRequestShape buildSquareAreaRequest (final BaseShapeServiceRequest request) {
        checkFieldPresent (request.getSquareSide (), SQUARE_SIDE);
        return SquareRequestShape
                .builder ()
                .squareSide (request.getSquareSide ())
                .build ();
    }

}
