package com.shape_service.dao.request;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SquareRequestShape extends BaseShapeServiceRequest {

    @NotNull (message = "Square side cannot be null")
    @Min (value = 0, message = "Square side must be greater than or equal to 0")
    private double squareSide;
}
