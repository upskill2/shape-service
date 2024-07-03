package com.shape.service.dao.request;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RectangleRequestShape extends BaseShapeServiceRequest {

    private Optional<Double> length;
    private Optional<Double> width;
}
