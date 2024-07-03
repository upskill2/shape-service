package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseShapeServiceRequest;
import com.shape_service.dao.request.CircleRequestShape;
import com.shape_service.service.ShapeCalculator;

import static com.shape_service.util.Utils.checkFieldPresent;
import static com.shape_service.util.Utils.getDouble;

public class CircleShapeCalculator implements ShapeCalculator {

    private static final double PI = 3.14159;
    public static final String CIRCLE_RADIUS = "Circle radius";

    @Override
    public double calculateArea (final BaseShapeServiceRequest request) {
        final CircleRequestShape circleRequest = buildCircleAreaRequest (request);
        return PI * Math.pow (getCircleRadius (circleRequest), 2);
    }

    @Override
    public double calculatePerimeter (final BaseShapeServiceRequest request) {
        final CircleRequestShape circleRequest = buildCircleAreaRequest (request);
        return 2 * PI * getCircleRadius (circleRequest);
    }

    private Double getCircleRadius (final CircleRequestShape circleRequest) {
        return getDouble (circleRequest.getRadius (), CIRCLE_RADIUS);
    }

    private CircleRequestShape buildCircleAreaRequest (final BaseShapeServiceRequest request) {
        checkFieldPresent (request.getRadius (), CIRCLE_RADIUS);
        return CircleRequestShape
                .builder ()
                .radius (request.getRadius ())
                .build ();
    }
}
