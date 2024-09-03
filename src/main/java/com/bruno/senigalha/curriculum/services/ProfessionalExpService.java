package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.entities.ProfessionalExp;
import com.bruno.senigalha.curriculum.repositories.ProfessionalExpRepository;
import com.bruno.senigalha.curriculum.services.exceptions.DatabaseException;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
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

    public ProfessionalExp insert(ProfessionalExp obj){
        return repository.save(obj);
    }

    public ProfessionalExp update(Long id, ProfessionalExp obj){
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        ProfessionalExp obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try{
            repository.delete(obj);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(ProfessionalExp entity, ProfessionalExp obj){
        entity.setCompany(obj.getCompany());
        entity.setPosition(obj.getPosition());
        entity.setActualJob(obj.getActualJob());
        entity.setDescription(obj.getDescription());
        entity.setStartDate(obj.getStartDate());
        entity.setEndDate(obj.getEndDate());
    }
}
