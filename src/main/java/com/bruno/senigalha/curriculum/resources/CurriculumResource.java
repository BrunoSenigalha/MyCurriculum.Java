package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.Curriculum;
import com.bruno.senigalha.curriculum.services.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/curricula")
public class CurriculumResource {

    @Autowired
    private CurriculumService service;

    @GetMapping
    public ResponseEntity<List<Curriculum>> findAll() {
        List<Curriculum> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Curriculum> findById(@PathVariable Long id) {
        Curriculum obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Curriculum> insert(@RequestBody Curriculum obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Curriculum> update(@PathVariable Long id, @RequestBody Curriculum obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
