package com.shape_service.dao.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TriangleRequestShape extends BaseShapeServiceRequest {

    private double triangleBase;
    private double height;
    private double triangleSide2;
    private double triangleSide3;

}
