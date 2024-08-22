package com.bruno.senigalha.curriculum.repositories;

import com.bruno.senigalha.curriculum.entities.AcademicExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicExpRepository extends JpaRepository<AcademicExp, Long> {
}
