package com.shape.service.service.impl;

import com.shape.service.dao.request.BaseShapeServiceRequest;
import com.shape.service.dao.request.RectangleRequestShape;
import com.shape.service.service.ShapeCalculator;

import static com.shape.service.util.Utils.checkFieldPresent;
import static com.shape.service.util.Utils.getDouble;

public class RectangleShapeCalculator implements ShapeCalculator {

    public static final String RECTANGLE_WIDTH = "Rectangle width";
    public static final String RECTANGLE_LENGTH = "Rectangle length";

    @Override
    public double calculateArea (final BaseShapeServiceRequest request) {
        final RectangleRequestShape rectangleRequest = buildRectangleAreaRequest (request);
        return getRectangleLength (rectangleRequest) * getRectangleWidth (rectangleRequest);
    }

    @Override
    public double calculatePerimeter (final BaseShapeServiceRequest request) {
        final RectangleRequestShape rectangleRequest = buildRectangleAreaRequest (request);
        return 2 * (getRectangleLength (rectangleRequest) + getRectangleWidth (rectangleRequest));
    }

    private RectangleRequestShape buildRectangleAreaRequest (final BaseShapeServiceRequest request) {
        checkFieldPresent (request.getWidth (), RECTANGLE_WIDTH);
        checkFieldPresent (request.getLength (), RECTANGLE_LENGTH);
        return RectangleRequestShape
                .builder ()
                .length (request.getLength ())
                .width (request.getWidth ())
                .build ();
    }

    private Double getRectangleWidth (final RectangleRequestShape rectangleRequest) {
        return getDouble (rectangleRequest.getWidth (), RECTANGLE_WIDTH);
    }

    private Double getRectangleLength (final RectangleRequestShape rectangleRequest) {
        return getDouble (rectangleRequest.getLength (), RECTANGLE_LENGTH);
    }

}
