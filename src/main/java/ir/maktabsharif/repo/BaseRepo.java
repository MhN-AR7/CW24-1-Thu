package ir.maktabsharif.repo;


import java.util.List;
import java.util.Optional;

public interface BaseRepo<T> {
    void insert(T t);
    Optional<T> findById(Long id);
    List<T> findAll();
    boolean update(T t);
    boolean delete(Long id);
}
