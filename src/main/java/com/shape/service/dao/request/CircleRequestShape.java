package com.shape.service.dao.request;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CircleRequestShape extends BaseShapeServiceRequest {

    private Optional<Double> radius;

}
