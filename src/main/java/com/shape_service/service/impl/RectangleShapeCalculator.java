package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseShapeServiceRequest;
import com.shape_service.dao.request.RectangleRequestShape;
import com.shape_service.service.ShapeCalculator;

public class RectangleShapeCalculator implements ShapeCalculator {

    @Override
    public double calculateArea (final BaseShapeServiceRequest request) {
        final RectangleRequestShape rectangleRequest = buildRectangleAreaRequest (request);
        return rectangleRequest.getLength () * rectangleRequest.getWidth ();
    }

    @Override
    public double calculatePerimeter (final BaseShapeServiceRequest request) {
        return 2 * (request.getLength () + request.getWidth ());
    }

    private RectangleRequestShape buildRectangleAreaRequest (final BaseShapeServiceRequest request) {
        return RectangleRequestShape
                .builder ()
                .length (request.getLength ())
                .width (request.getWidth ())
                .build ();
    }

}
