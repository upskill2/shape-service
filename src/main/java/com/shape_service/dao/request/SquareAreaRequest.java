package com.shape_service.dao.request;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SquareAreaRequest extends BaseAreaServiceRequest {

    @NotNull (message = "Side cannot be null")
    @Min (value = 0, message = "Side must be greater than or equal to 0")
    private double side;
}
