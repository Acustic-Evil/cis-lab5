package com;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PathLengthValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPathLength {
    String message() default "Path length does not match the sum of segment block lengths";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

