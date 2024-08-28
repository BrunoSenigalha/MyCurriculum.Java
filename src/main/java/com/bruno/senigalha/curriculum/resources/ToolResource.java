package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.entities.Tool;
import com.bruno.senigalha.curriculum.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tools")
public class ToolResource {

    @Autowired
    private ToolService service;

    @GetMapping
    public ResponseEntity<List<Tool>> findAll() {
        List<Tool> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tool> findById(@PathVariable Long id) {
        Tool obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Tool> insert(@RequestBody Tool obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
