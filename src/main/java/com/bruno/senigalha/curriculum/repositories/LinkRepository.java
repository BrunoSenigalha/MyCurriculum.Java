package com.bruno.senigalha.curriculum.repositories;

import com.bruno.senigalha.curriculum.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
}
