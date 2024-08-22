package com.bruno.senigalha.curriculum.repositories;

import com.bruno.senigalha.curriculum.entities.ProfessionalExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalExpRepository extends JpaRepository<ProfessionalExp, Long> {
}
