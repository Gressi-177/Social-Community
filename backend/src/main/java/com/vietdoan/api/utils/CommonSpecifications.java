package com.vietdoan.api.utils;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class CommonSpecifications {
    public static <T> Specification<T> likeField(String field, String value) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.like(root.get(field), "%" + value + "%");
            return predicate;
        };
    }

}