package ir.maktabsharif.repo.impl;

import ir.maktabsharif.repo.BaseRepo;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepoImpl<T> implements BaseRepo<T> {
    private final Class<T> entityClass;

    public BaseRepoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void insert(T entity) {
        HibernateUtil.inTxReturn(
                em -> {
                    em.persist(entity);
                    return entity;
                }
        );
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(
                HibernateUtil.read(em -> em.find(entityClass, id))
        );
    }

    @Override
    public List<T> findAll() {
        return HibernateUtil.read(
                em -> em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList()
        );
    }

    protected abstract void setUpdate(T oldEntity, T newEntity);

    protected abstract Long getId(T entity);

    @Override
    public boolean update(T entity) {
        return HibernateUtil.inTxReturn(
                em -> {
                    T oldEntity = em.find(entityClass, getId(entity));
                    if (oldEntity == null) return null;

                    setUpdate(oldEntity, entity);

                    return oldEntity;
                }
        ) != null;
    }

    @Override
    public boolean delete(Long id) {
        return HibernateUtil.inTxReturn(
                em -> {
                    T entity = em.find(entityClass, id);
                    if (entity == null) return null;

                    em.remove(entity);

                    return entity;
                }
        ) != null;
    }
}
