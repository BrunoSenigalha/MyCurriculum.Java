package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.Tool;
import com.bruno.senigalha.curriculum.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
