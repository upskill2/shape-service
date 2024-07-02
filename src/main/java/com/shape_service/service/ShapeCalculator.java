package com.shape_service.service;

import com.shape_service.dao.request.BaseShapeServiceRequest;

public interface ShapeCalculator {

    double calculateArea (BaseShapeServiceRequest request);

    double calculatePerimeter (BaseShapeServiceRequest request);
}
