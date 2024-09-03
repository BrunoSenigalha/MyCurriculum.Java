package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Tool;
import com.bruno.senigalha.curriculum.repositories.ToolRepository;
import com.bruno.senigalha.curriculum.services.exceptions.DatabaseException;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository repository;

    public List<Tool> findAll() {
        return repository.findAll();
    }

    public Tool findById(Long id) {
        Optional<Tool> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Tool insert(Tool obj){
        return repository.save(obj);
    }

    public Tool update(Long id, Tool obj) {
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        Tool obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Tool entity, Tool obj) {
        entity.setTool(obj.getTool());
    }
}
