package com.shape.service.dao.request;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SquareRequestShape extends BaseShapeServiceRequest {

    private Optional<Double> squareSide;
}
