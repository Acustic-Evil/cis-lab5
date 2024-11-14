package com;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Set;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем список блок-участков
        BlockSegment segment1 = new BlockSegment(100);
        BlockSegment segment2 = new BlockSegment(150);
        List<BlockSegment> segments = Arrays.asList(segment1, segment2);

        // Создаем объект PathSegment
        PathSegment pathSegment = new PathSegment(300, segments); // длина совпадает

        // Валидация
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<PathSegment>> violations = validator.validate(pathSegment);

        if (violations.isEmpty()) {
            System.out.println("Path data is valid");
        } else {
            violations.forEach(v -> System.out.println(v.getMessage()));
        }
    }
}