package ru.sevastopall.schoolapp.mapper;

public interface Mapper<F, T> {

    T map(F object);
}
