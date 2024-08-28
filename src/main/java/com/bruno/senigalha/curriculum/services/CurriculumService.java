package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Curriculum;
import com.bruno.senigalha.curriculum.repositories.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository repository;

    public List<Curriculum> findAll() {
        return repository.findAll();
    }

    public Curriculum findById(Long id) {
        Optional<Curriculum> obj = repository.findById(id);
        return obj.get();
    }

    public Curriculum insert(Curriculum obj){
        return repository.save(obj);
    }

}
