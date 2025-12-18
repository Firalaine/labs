package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyObjService {

    private final MyObj repository;

    public MyObjService(MyObj repository) {
        this.repository = repository;
    }

    public List<MyObject> getAll() {
        return repository.findAll();
    }

    public void create(MyObject obj) {
        repository.save(obj);
    }

    public boolean update(Long id, MyObject obj) {
        List<MyObject> existing = repository.findAll().stream()
                .filter(o -> o.getId().equals(id))
                .toList();
        if (existing.isEmpty()) return false;
        repository.update(id, obj);
        return true;
    }

    public boolean delete(Long id) {
        List<MyObject> existing = repository.findAll().stream()
                .filter(o -> o.getId().equals(id))
                .toList();
        if (existing.isEmpty()) return false;
        repository.delete(id);
        return true;
    }

    public MyObject getById(Long id) {
        return repository.findAll().stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
