package com.bruno.senigalha.curriculum.repositories;


import com.bruno.senigalha.curriculum.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
