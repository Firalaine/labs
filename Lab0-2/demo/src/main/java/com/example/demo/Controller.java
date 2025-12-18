package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objects")
public class Controller {

    private final MyObjService service;

    public Controller(MyObjService service) {
        this.service = service;
    }

    @GetMapping
    public List<MyObject> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyObject> getById(@PathVariable Long id) {
        MyObject obj = service.getById(id);
        return obj != null ? ResponseEntity.ok(obj) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody MyObject obj) {
        service.create(obj);
        return ResponseEntity.ok("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody MyObject obj) {
        boolean updated = service.update(id, obj);
        return updated ? ResponseEntity.ok("Updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.ok("Deleted") : ResponseEntity.notFound().build();
    }
}
