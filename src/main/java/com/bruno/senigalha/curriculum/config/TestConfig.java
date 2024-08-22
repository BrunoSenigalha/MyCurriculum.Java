package com.bruno.senigalha.curriculum.config;

import com.bruno.senigalha.curriculum.entities.Address;
import com.bruno.senigalha.curriculum.entities.Curriculum;
import com.bruno.senigalha.curriculum.entities.Language;
import com.bruno.senigalha.curriculum.entities.ProfessionalExp;
import com.bruno.senigalha.curriculum.enums.Gender;
import com.bruno.senigalha.curriculum.enums.Proficiencylevel;
import com.bruno.senigalha.curriculum.repositories.AddressRepository;
import com.bruno.senigalha.curriculum.repositories.CurriculumRepository;
import com.bruno.senigalha.curriculum.repositories.LanguageRepository;
import com.bruno.senigalha.curriculum.repositories.ProfessionalExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ProfessionalExpRepository professionalExpRepository;

    @Override
    public void run(String... args) throws Exception {


        Curriculum c1 = new Curriculum(null, " ", "Lucas Martins", Gender.MASCULINO, "Software Developer", "1699998888", "bruno@gmail.com", "www.linkedin.com.br");
        Curriculum c2 = new Curriculum(null, " ", "Jhon Spasia", Gender.PREFIRO_NAO_INFORMAR, "Technical Engineer", "11569822355", "john@gmail.com", "www.linkedin.com.br");
        Curriculum c3 = new Curriculum(null, " ", "Anastasia Rose", Gender.FEMININO, "Human Resources Manager", "55555555", "anastasia@gmail.com", "www.linkedin.com.br");
        curriculumRepository.saveAll(Arrays.asList(c1, c2, c3));

        Address a1 = new Address(null, "1566666", "São Paulo", "Brazil", c1);
        Address a2 = new Address(null, "588955", "Blumenau", "Brazil", c3);
        Address a3 = new Address(null, "5855558", "Manhattan", "United States", c2);
        addressRepository.saveAll(Arrays.asList(a1, a2, a3));

        ProfessionalExp px1 = new ProfessionalExp(null, "CompanyOne", "Dev", true, "Job Description", LocalDate.of(2014, 5, 1), LocalDate.of(2024, 8, 1), c2);
        ProfessionalExp px2 = new ProfessionalExp(null, "CompanyTwo", "Dev", false, "Job Description", LocalDate.of(2010, 10, 1), LocalDate.of(2013, 12, 1), c2);
        ProfessionalExp px3 = new ProfessionalExp(null, "CompanyThree", "TI", false, "Job Description", LocalDate.of(2000, 10, 1), LocalDate.of(2021, 3, 1), c1);
        professionalExpRepository.saveAll(Arrays.asList(px1, px2, px3));

        Language l1 = new Language(null, "English", Proficiencylevel.MEDIO, Proficiencylevel.AVANCADO, Proficiencylevel.MEDIO, c1);
        Language l2 = new Language(null, "Spanish", Proficiencylevel.AVANCADO, Proficiencylevel.FLUENTE, Proficiencylevel.FLUENTE, c1);
        Language l3 = new Language(null, "Franchise", Proficiencylevel.BASICO, Proficiencylevel.BASICO, Proficiencylevel.BASICO, c1);
        Language l4 = new Language(null, "English", Proficiencylevel.MEDIO, Proficiencylevel.AVANCADO, Proficiencylevel.MEDIO, c2);
        Language l5 = new Language(null, "English", Proficiencylevel.AVANCADO, Proficiencylevel.FLUENTE, Proficiencylevel.FLUENTE, c3);
        Language l6 = new Language(null, "Portuguese", Proficiencylevel.BASICO, Proficiencylevel.BASICO, Proficiencylevel.BASICO, c3);
        languageRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));


    }
}
