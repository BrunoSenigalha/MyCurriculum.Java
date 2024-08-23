package com.bruno.senigalha.curriculum.resources;

import com.bruno.senigalha.curriculum.entities.AcademicExp;
import com.bruno.senigalha.curriculum.entities.Project;
import com.bruno.senigalha.curriculum.repositories.ProjectRepository;
import com.bruno.senigalha.curriculum.services.AcademicExpService;
import com.bruno.senigalha.curriculum.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectResource {

    @Autowired
    private ProjectService service;

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        List<Project> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        Project obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
}
