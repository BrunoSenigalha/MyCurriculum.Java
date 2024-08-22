package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }

}
