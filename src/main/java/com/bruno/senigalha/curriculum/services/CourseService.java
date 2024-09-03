package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Course;
import com.bruno.senigalha.curriculum.repositories.CourseRepository;
import com.bruno.senigalha.curriculum.services.exceptions.DatabaseException;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> findAll() {
        return repository.findAll();
    }

    public Course findById(Long id) {
        Optional<Course> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Course insert(Course course) {
        return repository.save(course);
    }

    public Course update(Long id, Course obj) {
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                }).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        Course entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Course entity, Course obj) {
        entity.setTypeCourse(obj.getTypeCourse());
        entity.setTitle(obj.getTitle());
        entity.setDescription(obj.getDescription());
    }
}
