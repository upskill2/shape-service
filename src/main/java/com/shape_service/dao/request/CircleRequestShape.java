package com.shape_service.dao.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CircleRequestShape extends BaseShapeServiceRequest {

    private double radius;

}
