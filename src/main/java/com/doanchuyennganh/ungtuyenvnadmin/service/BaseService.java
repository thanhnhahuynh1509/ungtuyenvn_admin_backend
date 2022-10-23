package com.doanchuyennganh.ungtuyenvnadmin.service;

import com.doanchuyennganh.ungtuyenvnadmin.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<T, ID> {

    protected final JpaRepository<T, ID> baseRepository;

    protected BaseService(JpaRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    protected T getSingleResultById(ID id) {
        return baseRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
    }

    public List<T> gets() {
        return baseRepository.findAll();
    }

    public T get(ID id) {
        return getSingleResultById(id);
    }

    public T save(T model) {
        return baseRepository.save(model);
    }

    public abstract T update(ID id, T model);

    public void delete(ID id) {
        getSingleResultById(id);
        baseRepository.deleteById(id);
    }
}
