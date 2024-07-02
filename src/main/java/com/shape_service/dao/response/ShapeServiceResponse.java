package com.shape_service.dao.response;

import com.shape_service.shapes.CalculationType;
import com.shape_service.shapes.ShapeType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShapeServiceResponse {
    private CalculationType calculationType;
    private ShapeType shape;
    private double result;
}
