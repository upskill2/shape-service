package com.shape.service.service;

import com.shape.service.dao.request.BaseShapeServiceRequest;

public interface ShapeCalculator {

    double calculateArea (BaseShapeServiceRequest request);

    double calculatePerimeter (BaseShapeServiceRequest request);
}
