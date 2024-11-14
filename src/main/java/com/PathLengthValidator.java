package com;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PathLengthValidator implements ConstraintValidator<ValidPathLength, PathSegment> {

    @Override
    public boolean isValid(PathSegment pathSegment, ConstraintValidatorContext context) {
        if (pathSegment == null) {
            return true; // Если объект null, пропускаем проверку
        }

        int calculatedLength = pathSegment.getBlockSegments()
                .stream()
                .mapToInt(BlockSegment::getLength)
                .sum();

        return pathSegment.getLengthInMeters() == calculatedLength;
    }
}
