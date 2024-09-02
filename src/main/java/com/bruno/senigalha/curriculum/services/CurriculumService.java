package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Curriculum;
import com.bruno.senigalha.curriculum.repositories.CurriculumRepository;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
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

    public Curriculum update(Long id, Curriculum obj){
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                return repository.save(entity);
                })
                .orElseThrow(()-> new ResourceNotFoundException(id));

//        Optional<Curriculum> findEntity = repository.findById(id);
////        findEntity.ifPresent(curriculum -> updateData(curriculum, obj));
//        if (findEntity.isPresent()){
//            Curriculum entity = findEntity.get();
//            updateData(entity, obj);
//            repository.save(entity);
//        }
//        return findEntity.orElse(null);
    }

    public void delete(Long id){
        Curriculum entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(entity);
    }

    private void updateData(Curriculum entity, Curriculum obj){
        entity.setPicture(obj.getPicture());
        entity.setName(obj.getName());
        entity.setGender(obj.getGender());
        entity.setAddress(obj.getAddress());
        entity.setProfessionalGoals(obj.getProfessionalGoals());
        entity.setPhone(obj.getPhone());
        entity.setEmail(obj.getEmail());
        entity.setLinkedIn(obj.getLinkedIn());
    }
}
