package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/objects"})
public class Controller {
    private final Map<Long, MyObject> store = new HashMap();
    private final AtomicLong idGenerator = new AtomicLong(0L);

    @PostMapping
    public ResponseEntity<MyObject> create(@RequestBody MyObject obj) {
        long id = this.idGenerator.incrementAndGet();
        obj.setId(id);
        this.store.put(id, obj);
        return ResponseEntity.status(201).body(obj);
    }

    @GetMapping
    public ResponseEntity<List<MyObject>> getAll() {
        return ResponseEntity.ok(new ArrayList(this.store.values()));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<MyObject> getById(@PathVariable Long id) {
        MyObject obj = (MyObject)this.store.get(id);
        return obj != null ? ResponseEntity.ok(obj) : ResponseEntity.notFound().build();
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<MyObject> update(@PathVariable Long id, @RequestBody MyObject obj) {
        if (this.store.containsKey(id)) {
            obj.setId(id);
            this.store.put(id, obj);
            return ResponseEntity.ok(obj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (this.store.containsKey(id)) {
            this.store.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}