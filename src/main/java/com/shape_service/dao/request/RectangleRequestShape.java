package com.shape_service.dao.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RectangleRequestShape extends BaseShapeServiceRequest {

    private double length;
    private double width;
}
