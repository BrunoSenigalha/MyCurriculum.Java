package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.repositories.LanguageRepository;
import com.bruno.senigalha.curriculum.services.exceptions.DatabaseException;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository repository;

    public List<Language> findAll() {
        return repository.findAll();
    }

    public Language findById(Long id) {
        Optional<Language> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Language insert(Language obj) {
        return repository.save(obj);
    }

    public Language update(Long id, Language obj) {
        return repository.findById(id).map(entity -> {
            updateData(entity, obj);
            return repository.save(entity);
        }).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        Language obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Language entity, Language obj) {
        entity.setLanguage(obj.getLanguage());
        entity.setConversationLevel(obj.getConversationLevel());
        entity.setComprehensionLevel(obj.getComprehensionLevel());
        entity.setWritingLevel(obj.getWritingLevel());
    }
}
