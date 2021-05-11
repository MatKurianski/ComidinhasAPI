package com.kurianski.comidinhas.adapter.entity.mapper;

public interface EntityMapper<T, U> {
    U map(T t);
}
