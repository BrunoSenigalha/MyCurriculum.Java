package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/languages")
public class LanguageResource {

    @Autowired
    private LanguageService service;

    @GetMapping
    public ResponseEntity<List<Language>> findAll(){
        List<Language> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Language> findById(@PathVariable Long id){
        Language obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
}
