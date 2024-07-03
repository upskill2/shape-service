package com.shape.service.util;

import com.shape.service.exception.NegativeShapeParameterException;
import com.shape.service.exception.MissingShapeParametersException;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor (access = lombok.AccessLevel.PRIVATE)
public class Utils {

    public static Double getDouble (final Optional<Double> parameter, String shapeName) {
       double paramValue = parameter.orElse (-1.0);
        if(paramValue<=0)
            throw new NegativeShapeParameterException ("Negative shape parameters for " + shapeName);
        return paramValue;
    }

    public static Optional<Double> checkFieldPresent (final Optional<Double> parameter, String shapeName) {
        if(parameter==null)
            throw new MissingShapeParametersException ("Missing parameters for " + shapeName);
        return parameter;
    }
}
