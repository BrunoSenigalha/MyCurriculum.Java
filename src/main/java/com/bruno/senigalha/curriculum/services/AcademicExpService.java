package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.AcademicExp;
import com.bruno.senigalha.curriculum.entities.Curriculum;
import com.bruno.senigalha.curriculum.repositories.AcademicExpRepository;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public AcademicExp insert(AcademicExp obj) {
        return repository.save(obj);
    }

    public AcademicExp update(Long id, AcademicExp obj) {
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
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
