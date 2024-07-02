package com.shape_service.dao.request;

import lombok.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseShapeServiceRequest {

    @Min(value = 0, message = "Square side must be greater than or equal to 0")
    private double squareSide;
    @Min(value = 0, message = "Shape parameters must be greater than or equal to 0")
    private double length;
    @Min(value = 0, message = "Shape parameters must be greater than or equal to 0")
    private double width;
    @Min(value = 0, message = "Shape parameters must be greater than or equal to 0")
    private double radius;
    @Min(value = 0, message = "Shape parameters must be greater than or equal to 0")
    private double triangleBase;
    @Min(value = 0, message = "Shape parameters must be greater than or equal to 0")
    private double triangleSide2;
    @Min(value = 0, message = "Shape parameters must be greater than or equal to 0")
    private double triangleSide3;
    @Min(value = 0, message = "Shape parameters must be greater than or equal to 0")
    private double height;
}
