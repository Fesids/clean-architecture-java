package com.application.rg.domain.input_boundary.base;

public interface InputBoundary<T> {
    void execute(T request);
}
