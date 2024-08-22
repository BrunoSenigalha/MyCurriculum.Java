package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.AcademicExp;
import com.bruno.senigalha.curriculum.repositories.AcademicExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicExpService {

    @Autowired
    private AcademicExpRepository repository;

    public List<AcademicExp> findAll() {
        return repository.findAll();
    }

    public AcademicExp findById(Long id) {
        Optional<AcademicExp> obj = repository.findById(id);
        return obj.get();
    }
}
