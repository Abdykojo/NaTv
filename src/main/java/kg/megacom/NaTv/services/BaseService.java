package kg.megacom.NaTv.services;

import java.util.List;

public interface BaseService<T> {
    T save(T t);
    T findById(Long id);
    List<T> findAll();
}

