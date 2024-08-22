package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.AcademicExp;
import com.bruno.senigalha.curriculum.services.AcademicExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/academic_experiences")
public class AcademicExpResource {

    @Autowired
    private AcademicExpService service;

    @GetMapping
    public ResponseEntity<List<AcademicExp>> findAll() {
        List<AcademicExp> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AcademicExp> findById(@PathVariable Long id) {
        AcademicExp obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
}
