package com.shape_service.service;

import com.shape_service.component.ShapeCalculatorServiceFactory;
import com.shape_service.dao.request.BaseAreaServiceRequest;
import com.shape_service.exception.UnsupportedShapeException;
import com.shape_service.shapes.Shapes;
import org.springframework.stereotype.Service;

@Service
public class AreaCalculatorService {

    private final ShapeCalculatorServiceFactory factory;

    public AreaCalculatorService (ShapeCalculatorServiceFactory factory) {
        this.factory = factory;
    }

    public double calculateArea (BaseAreaServiceRequest request, String shapeType) {


        Shapes shape = null;
        try {
            shape = Shapes.valueOf (shapeType.toUpperCase ());
        } catch (IllegalArgumentException e) {
            throw new UnsupportedShapeException (shapeType);
        }
        ShapeCalculatorService service = factory.getService (shape);
        return service.calculateArea (request);
    }
}
