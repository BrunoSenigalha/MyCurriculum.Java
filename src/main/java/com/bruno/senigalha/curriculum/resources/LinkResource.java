package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.Link;
import com.bruno.senigalha.curriculum.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/links")
public class LinkResource {

    @Autowired
    private LinkService service;

    @GetMapping
    public ResponseEntity<List<Link>> findAll() {
        List<Link> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Link> findById(@PathVariable Long id) {
        Link obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
}
