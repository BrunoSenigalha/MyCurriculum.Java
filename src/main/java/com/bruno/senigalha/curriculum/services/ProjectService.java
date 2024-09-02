package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Project;
import com.bruno.senigalha.curriculum.repositories.ProjectRepository;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(Long id) {
        Optional<Project> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Project insert(Project obj){
        return repository.save(obj);
    }
}
