package org.chdtu.service;

import org.chdtu.model.University;
import org.chdtu.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public Optional<University> findById(Long id) {
        return universityRepository.findById(id);
    }

    public University save(University university) {
        return universityRepository.save(university);
    }

    public void deleteById(Long id) {
        universityRepository.deleteById(id);
    }
}