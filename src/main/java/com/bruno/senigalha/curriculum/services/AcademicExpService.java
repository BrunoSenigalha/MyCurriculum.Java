package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.AcademicExp;
import com.bruno.senigalha.curriculum.repositories.AcademicExpRepository;
import com.bruno.senigalha.curriculum.services.exceptions.DatabaseException;
import com.bruno.senigalha.curriculum.services.exceptions.InvalidDateException;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import com.bruno.senigalha.curriculum.services.validations.DataValidation;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public AcademicExp insert(AcademicExp obj) {
        try {
            DataValidation.dataValidation(obj.getStartDate(), obj.getEndDate());
            return repository.save(obj);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(e.getMessage());
        }
    }

    public AcademicExp update(Long id, AcademicExp obj) {
        AcademicExp entity = repository.findById(id)
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
        AcademicExp obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(AcademicExp entity, AcademicExp obj) {
        entity.setCourseName(obj.getCourseName());
        entity.setInstitution(obj.getInstitution());
        entity.setDegree(obj.getDegree());
        entity.setFormationType(obj.getFormationType());
        entity.setFormationStatus(obj.getFormationStatus());
        entity.setStudying(obj.getStudying());
        entity.setStartDate(obj.getStartDate());
        entity.setEndDate(obj.getEndDate());
    }
}
