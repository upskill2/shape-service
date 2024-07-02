package com.shape_service.service.impl;

import com.shape_service.dao.request.BaseShapeServiceRequest;
import com.shape_service.dao.request.TriangleRequestShape;
import com.shape_service.service.ShapeCalculator;

public class TriangleShapeCalculator implements ShapeCalculator {

    @Override
    public double calculateArea (final BaseShapeServiceRequest request) {
        final TriangleRequestShape triangleRequest = buildTriangleAreaRequest (request);
        return triangleRequest.getTriangleBase () * triangleRequest.getHeight () / 2;
    }

    @Override
    public double calculatePerimeter (final BaseShapeServiceRequest request) {
        final TriangleRequestShape triangleRequest = buildTriangleAreaRequest (request);

        return triangleRequest.getTriangleBase () + triangleRequest.getTriangleSide2 () + triangleRequest.getTriangleSide3 ();
    }

    private TriangleRequestShape buildTriangleAreaRequest (final BaseShapeServiceRequest request) {
        return TriangleRequestShape
                .builder ()
                .triangleBase (request.getTriangleBase ())
                .triangleSide3 (request.getTriangleSide3 ())
                .triangleSide2 (request.getTriangleSide2 ())
                .height (request.getHeight ())
                .build ();
    }

}
