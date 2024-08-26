package com.bruno.senigalha.curriculum.repositories;

import com.bruno.senigalha.curriculum.entities.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
}
