package com.shape_service.dao.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RectangleAreaRequest extends BaseAreaServiceRequest {

    private double length;
    private double width;
}
