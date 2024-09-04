package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.ProfessionalExp;
import com.bruno.senigalha.curriculum.repositories.ProfessionalExpRepository;
import com.bruno.senigalha.curriculum.services.exceptions.DatabaseException;
import com.bruno.senigalha.curriculum.services.exceptions.InvalidDateException;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import com.bruno.senigalha.curriculum.services.validations.DataValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ProfessionalExp insert(ProfessionalExp obj) {
        try {
            DataValidation.dataValidation(obj.getStartDate(), obj.getEndDate());
            return repository.save(obj);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(e.getMessage());
        }
    }

    public ProfessionalExp update(Long id, ProfessionalExp obj) {
        ProfessionalExp entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            DataValidation.dataValidation(obj.getStartDate(), obj.getEndDate());
            updateData(entity, obj);
            return repository.save(entity);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(e.getMessage());
        }
    }

    public void delete(Long id) {
        ProfessionalExp obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(ProfessionalExp entity, ProfessionalExp obj) {
        entity.setCompany(obj.getCompany());
        entity.setPosition(obj.getPosition());
        entity.setActualJob(obj.getActualJob());
        entity.setDescription(obj.getDescription());
        entity.setStartDate(obj.getStartDate());
        entity.setEndDate(obj.getEndDate());
    }
}
