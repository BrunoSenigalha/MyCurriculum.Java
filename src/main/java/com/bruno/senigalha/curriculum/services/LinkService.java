package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Link;
import com.bruno.senigalha.curriculum.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;

    public List<Link> findAll() {
        return repository.findAll();
    }

    public Link findById(Long id) {
        Optional<Link> obj = repository.findById(id);
        return obj.get();
    }
}
