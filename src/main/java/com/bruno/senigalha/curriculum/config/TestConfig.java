package com.bruno.senigalha.curriculum.config;

import com.bruno.senigalha.curriculum.entities.Curriculum;
import com.bruno.senigalha.curriculum.repositories.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Override
    public void run(String... args) throws Exception {

        Curriculum c1 = new Curriculum(null, " ", "Bruno Senigalha", "Software Developer", "1699998888", "bruno@gmail.com", "www.linkedin.com.br" );

        curriculumRepository.saveAll(List.of(c1));
    }
}
