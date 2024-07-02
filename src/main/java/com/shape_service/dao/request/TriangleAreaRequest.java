package com.shape_service.dao.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TriangleAreaRequest extends BaseAreaServiceRequest {

    private double base;
    private double height;

}
