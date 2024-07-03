package com.shape.service.dao.request;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TriangleRequestShape extends BaseShapeServiceRequest {

    private Optional<Double> triangleBase;
    private Optional<Double> height;
    private Optional<Double> triangleSide2;
    private Optional<Double> triangleSide3;
}
