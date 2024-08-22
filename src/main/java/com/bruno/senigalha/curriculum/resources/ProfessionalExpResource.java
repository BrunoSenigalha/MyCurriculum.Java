package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.ProfessionalExp;
import com.bruno.senigalha.curriculum.services.ProfessionalExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/experiences")
public class ProfessionalExpResource {

    @Autowired
    private ProfessionalExpService service;

    @GetMapping
    public ResponseEntity<List<ProfessionalExp>> findAll(){
        List<ProfessionalExp> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfessionalExp> findById(@PathVariable Long id){
        ProfessionalExp obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
}
