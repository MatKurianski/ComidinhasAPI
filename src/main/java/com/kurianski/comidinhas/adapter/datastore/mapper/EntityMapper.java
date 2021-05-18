package com.kurianski.comidinhas.adapter.datastore.mapper;

public interface EntityMapper<T, U> {
    U map(T t);
}
