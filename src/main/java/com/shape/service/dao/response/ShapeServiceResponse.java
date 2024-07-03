package com.shape.service.dao.response;

import com.shape.service.shapes.CalculationType;
import com.shape.service.shapes.ShapeType;
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
