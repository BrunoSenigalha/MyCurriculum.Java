package com.bruno.senigalha.curriculum.repositories;

import com.bruno.senigalha.curriculum.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
