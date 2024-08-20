package com.bruno.senigalha.curriculum.repositories;

import com.bruno.senigalha.curriculum.entities.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}
