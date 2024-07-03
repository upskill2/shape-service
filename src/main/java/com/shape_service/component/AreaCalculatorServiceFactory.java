package com.shape_service.component;

import com.shape_service.service.ShapeCalculator;
import com.shape_service.service.impl.CircleShapeCalculator;
import com.shape_service.service.impl.RectangleShapeCalculator;
import com.shape_service.service.impl.SquareShapeCalculator;
import com.shape_service.service.impl.TriangleShapeCalculator;
import com.shape_service.shapes.ShapeType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

import static com.shape_service.shapes.ShapeType.*;

@Component
public class AreaCalculatorServiceFactory {

    private final Map<ShapeType, ShapeCalculator> serviceMap;

    public AreaCalculatorServiceFactory () {
        serviceMap = new EnumMap<> (ShapeType.class);
        serviceMap.put (SQUARE, new SquareShapeCalculator ());
        serviceMap.put (TRIANGLE, new TriangleShapeCalculator ());
        serviceMap.put (CIRCLE, new CircleShapeCalculator ());
        serviceMap.put (RECTANGLE, new RectangleShapeCalculator ());
    }

    public ShapeCalculator getService (ShapeType shape) {
        return serviceMap.get (shape);
    }
}