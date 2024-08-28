package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.entities.ProfessionalExp;
import com.bruno.senigalha.curriculum.repositories.ProfessionalExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalExpService {

    @Autowired
    private ProfessionalExpRepository repository;

    public List<ProfessionalExp> findAll() {
        return repository.findAll();
    }

    public ProfessionalExp findById(Long id) {
        Optional<ProfessionalExp> obj = repository.findById(id);
        return obj.get();
    }

    public ProfessionalExp insert(ProfessionalExp obj){
        return repository.save(obj);
    }
}
