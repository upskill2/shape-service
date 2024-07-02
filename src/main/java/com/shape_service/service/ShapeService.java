package com.shape_service.service;

import com.shape_service.component.AreaCalculatorServiceFactory;
import com.shape_service.dao.request.BaseShapeServiceRequest;
import com.shape_service.dao.response.ShapeServiceResponse;
import com.shape_service.exception.UnsupportedCalculationTypeException;
import com.shape_service.exception.UnsupportedShapeException;
import com.shape_service.shapes.CalculationType;
import com.shape_service.shapes.ShapeType;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    private final AreaCalculatorServiceFactory factory;

    public ShapeService (AreaCalculatorServiceFactory factory) {
        this.factory = factory;
    }

    public ShapeServiceResponse calculate (BaseShapeServiceRequest request, String shapeType, final String calculationType) {
        ShapeType shape = getShape (shapeType);
        CalculationType type = getCalculationType (calculationType);
        ShapeCalculator service = factory.getService (shape);

        double result = type == CalculationType.PERIMETER ? service.calculatePerimeter (request) : service.calculateArea (request);

        return ShapeServiceResponse.builder ()
                .calculationType (type)
                .shape (shape)
                .result (result)
                .build ();
    }

    private ShapeType getShape (final String shapeType) {
        try {
            return ShapeType.valueOf (shapeType.toUpperCase ());
        } catch (IllegalArgumentException e) {
            throw new UnsupportedShapeException (shapeType);
        }
    }

    private CalculationType getCalculationType (final String calculationType) {
        try {
            return CalculationType.valueOf (calculationType.toUpperCase ());
        } catch (IllegalArgumentException e) {
            throw new UnsupportedCalculationTypeException (calculationType);
        }
    }

}
