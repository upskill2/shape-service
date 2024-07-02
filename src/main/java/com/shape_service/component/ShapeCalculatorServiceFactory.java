package com.shape_service.component;

import com.shape_service.service.ShapeCalculatorService;
import com.shape_service.service.impl.CircleShapeCalculatorService;
import com.shape_service.service.impl.SquareShapeCalculatorService;
import com.shape_service.service.impl.TriangleShapeCalculatorService;
import com.shape_service.shapes.Shapes;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.shape_service.shapes.Shapes.*;

@Component
public class ShapeCalculatorServiceFactory {

    private final Map<Shapes, ShapeCalculatorService> serviceMap;

    public ShapeCalculatorServiceFactory () {
        serviceMap = new HashMap<> ();
        serviceMap.put (SQUARE, new SquareShapeCalculatorService ());
        serviceMap.put (TRIANGLE, new TriangleShapeCalculatorService ());
        serviceMap.put (CIRCLE, new CircleShapeCalculatorService ());
        serviceMap.put (RECTANGLE, new SquareShapeCalculatorService ());
    }

    public ShapeCalculatorService getService (Shapes shape) {
        return serviceMap.get (shape);
    }
}