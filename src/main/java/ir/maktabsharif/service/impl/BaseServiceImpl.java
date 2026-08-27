package ir.maktabsharif.service.impl;

import ir.maktabsharif.exception.BusinessException;
import ir.maktabsharif.exception.EntityNotFoundException;
import ir.maktabsharif.exception.InvalidDataException;
import ir.maktabsharif.repo.BaseRepo;
import ir.maktabsharif.service.BaseService;
import ir.maktabsharif.util.Rule;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    private final BaseRepo<T> repo;

    public BaseServiceImpl(BaseRepo<T> repo) {
        this.repo = repo;
    }

    @Override
    public T register(T entity) throws BusinessException {
        validate(entity);

        repo.insert(entity);

        return entity;
    }

    @Override
    public T getById(Long id) throws BusinessException {
        Rule.check(
                id <= 0,
                InvalidDataException::new,
                "ID Must be Positive!"
        );

        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity Not Found!"));
    }

    @Override
    public List<T> getAll() {
        return repo.findAll();
    }

    protected abstract Long getId(T entity);

    @Override
    public T change(T entity) throws BusinessException {
        Rule.check(
                getId(entity) <= 0,
                InvalidDataException::new,
                "ID Must be Positive!"
        );

        validate(entity);

        Rule.check(
                !repo.update(entity),
                EntityNotFoundException::new,
                "Entity Not Found!"
        );

        return entity;
    }

    @Override
    public void remove(Long id) throws BusinessException {
        Rule.check(
                id <= 0,
                InvalidDataException::new,
                "ID Must be Positive!"
        );

        Rule.check(
                !repo.delete(id),
                EntityNotFoundException::new,
                "Entity Not Found!"
        );
    }

    public abstract void validate(T t) throws BusinessException;
}
