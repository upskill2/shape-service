package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseShapeServiceRequest;
import com.shape_service.dao.request.CircleRequestShape;
import com.shape_service.service.ShapeCalculator;

public class CircleShapeCalculator implements ShapeCalculator {

    private static final double PI = 3.14159;

    @Override
    public double calculateArea (final BaseShapeServiceRequest request) {
        final CircleRequestShape circleRequest = buildCircleAreaRequest (request);
        return PI * circleRequest.getRadius () * circleRequest.getRadius ();
    }

    @Override
    public double calculatePerimeter (final BaseShapeServiceRequest request) {
        final CircleRequestShape circleRequest = buildCircleAreaRequest (request);
        return 2 * PI * circleRequest.getRadius ();
    }

    private CircleRequestShape buildCircleAreaRequest (final BaseShapeServiceRequest request) {
        return CircleRequestShape
                .builder ()
                .radius (request.getRadius ())
                .build ();
    }

}
