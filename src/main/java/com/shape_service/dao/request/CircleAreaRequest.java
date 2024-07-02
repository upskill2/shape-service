package com.shape_service.dao.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CircleAreaRequest extends BaseAreaServiceRequest {

    private double radius;

}
