package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.Curriculum;
import com.bruno.senigalha.curriculum.services.CurriculumService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/{curricula}")
public class CurriculumResource {

    @Autowired
    private CurriculumService service;

    @GetMapping
    public ResponseEntity<List<Curriculum>> findAll(){
        List<Curriculum> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Curriculum> findById(@PathVariable Long id){
        Curriculum obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
}
