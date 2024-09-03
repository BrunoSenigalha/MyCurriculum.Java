package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Project;
import com.bruno.senigalha.curriculum.repositories.ProjectRepository;
import com.bruno.senigalha.curriculum.services.exceptions.DatabaseException;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Project insert(Project obj) {
        return repository.save(obj);
    }

    public Project update(Long id, Project obj) {
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        Project obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Project entity, Project obj) {
        entity.setProjectName(obj.getProjectName());
        entity.setLink(obj.getLink());
        entity.setDescription(obj.getDescription());
    }
}
