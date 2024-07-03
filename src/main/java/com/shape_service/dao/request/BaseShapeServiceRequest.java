package com.shape_service.dao.request;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseShapeServiceRequest {

    private Optional<Double> squareSide;
    private Optional<Double> length;
    private Optional<Double> width;
    private Optional<Double> radius;
    private Optional<Double> triangleBase;
    private Optional<Double> triangleSide2;
    private Optional<Double> triangleSide3;
    private Optional<Double> height;
}
