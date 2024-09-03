package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.entities.Link;
import com.bruno.senigalha.curriculum.repositories.LinkRepository;
import com.bruno.senigalha.curriculum.services.exceptions.DatabaseException;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;

    public List<Link> findAll() {
        return repository.findAll();
    }

    public Link findById(Long id) {
        Optional<Link> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Link insert(Link obj){
        return repository.save(obj);
    }

    public Link update(Long id, Link obj){
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        Link obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try{
            repository.delete(obj);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Link entity, Link obj){
        entity.setLink(obj.getLink());
    }
}
