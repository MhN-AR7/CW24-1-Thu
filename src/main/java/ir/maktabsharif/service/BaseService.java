package ir.maktabsharif.service;

import ir.maktabsharif.exception.BusinessException;

import java.util.List;

public interface BaseService<T> {
    T register(T t) throws BusinessException;
    T getById(Long id) throws BusinessException;
    List<T> getAll();
    T change(T t) throws BusinessException;
    void remove(Long id) throws BusinessException;
}
