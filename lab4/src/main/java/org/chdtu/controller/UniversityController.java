package org.chdtu.controller;

import org.chdtu.model.University;
import org.chdtu.repository.UniversityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityRepository universityRepository;

    public UniversityController(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<University> getById(@PathVariable Long id) {
        return universityRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public University create(@RequestBody University university) {
        return universityRepository.save(university);
    }

    @PutMapping("/{id}")
    public University update(@PathVariable Long id, @RequestBody University universityDetails) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id: " + id));
        university.setName(universityDetails.getName());
        return universityRepository.save(university);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (universityRepository.existsById(id)) {
            universityRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
