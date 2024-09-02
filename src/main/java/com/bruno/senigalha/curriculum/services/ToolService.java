package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.entities.Tool;
import com.bruno.senigalha.curriculum.repositories.ToolRepository;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
}
