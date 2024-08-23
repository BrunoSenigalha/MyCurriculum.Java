package com.bruno.senigalha.curriculum.repositories;

import com.bruno.senigalha.curriculum.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
