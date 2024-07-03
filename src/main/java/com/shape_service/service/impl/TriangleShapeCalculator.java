package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseShapeServiceRequest;
import com.shape_service.dao.request.TriangleRequestShape;
import com.shape_service.service.ShapeCalculator;

import static com.shape_service.util.Utils.checkFieldPresent;
import static com.shape_service.util.Utils.getDouble;

public class TriangleShapeCalculator implements ShapeCalculator {

    public static final String TRIANGLE_BASE = "Triangle base";
    public static final String TRIANGLE_HEIGHT = "Triangle height";
    public static final String TRIANGLE_SIDE_2 = "Triangle side 2";
    public static final String TRIANGLE_SIDE_3 = "Triangle side 3";

    @Override
    public double calculateArea (final BaseShapeServiceRequest request) {
        final TriangleRequestShape triangleRequest = buildTriangleAreaRequest (request);
        final Double base = getTriangleBase (triangleRequest);
        final Double height = getDouble (triangleRequest.getHeight (), TRIANGLE_HEIGHT);
        return base * height / 2;
    }

    @Override
    public double calculatePerimeter (final BaseShapeServiceRequest request) {
        final TriangleRequestShape triangleRequest = buildTriangleAreaRequest (request);
        final Double base = getTriangleBase (triangleRequest);
        final Double side2 = getDouble (triangleRequest.getTriangleSide2 (), TRIANGLE_SIDE_2);
        final Double side3 = getDouble (triangleRequest.getTriangleSide3 (), TRIANGLE_SIDE_3);
        return base + side2 + side3;
    }

    private TriangleRequestShape buildTriangleAreaRequest (final BaseShapeServiceRequest request) {
        checkFieldPresent (request.getTriangleBase (), TRIANGLE_BASE);
        checkFieldPresent (request.getTriangleSide2 (), TRIANGLE_SIDE_2);
        checkFieldPresent (request.getTriangleSide3 (), TRIANGLE_SIDE_3);
        checkFieldPresent (request.getHeight (), TRIANGLE_HEIGHT);
        return TriangleRequestShape
                .builder ()
                .triangleBase (request.getTriangleBase ())
                .triangleSide3 (request.getTriangleSide3 ())
                .triangleSide2 (request.getTriangleSide2 ())
                .height (request.getHeight ())
                .build ();
    }

    private Double getTriangleBase (final TriangleRequestShape triangleRequest) {
        return getDouble (triangleRequest.getTriangleBase (), TRIANGLE_BASE);
    }

}
