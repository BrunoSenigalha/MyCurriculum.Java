package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.AcademicExp;
import com.bruno.senigalha.curriculum.services.AcademicExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<AcademicExp> insert(@RequestBody AcademicExp obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AcademicExp> update(@PathVariable Long id, @RequestBody AcademicExp obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok(obj);
    }
}
