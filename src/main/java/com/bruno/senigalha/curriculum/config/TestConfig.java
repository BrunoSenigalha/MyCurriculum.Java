package com.bruno.senigalha.curriculum.config;

import com.bruno.senigalha.curriculum.entities.*;
import com.bruno.senigalha.curriculum.enums.*;
import com.bruno.senigalha.curriculum.repositories.*;
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

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private AcademicExpRepository academicExpRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {


        Curriculum c1 = new Curriculum(null, " ", "Lucas Martins", Gender.MASCULINO, "Software Developer", "1699998888", "lucas@gmail.com", "www.linkedin.com.br");
        Curriculum c2 = new Curriculum(null, " ", "Jhon Spasia", Gender.PREFIRO_NAO_INFORMAR, "Technical Engineer", "11569822355", "john@gmail.com", "www.linkedin.com.br");
        Curriculum c3 = new Curriculum(null, " ", "Anastasia Rose", Gender.FEMININO, "Human Resources Manager", "55555555", "anastasia@gmail.com", "www.linkedin.com.br");
        curriculumRepository.saveAll(Arrays.asList(c1, c2, c3));

        Address a1 = new Address(null, "1566666","São Paulo", "São Paulo", "Brazil", c1);
        Address a2 = new Address(null, "588955", "Santa Catarina", "Blumenau", "Brazil", c2);
        Address a3 = new Address(null, "5855558", "New York","Manhattan", "United States", c3);
        addressRepository.saveAll(Arrays.asList(a1, a2, a3));

        AcademicExp ax1 = new AcademicExp(null, "Quimica", "Puc", FormationType.SUPERIOR, Degree.MESTRADO, FormationStatus.COMPLETO, false, LocalDate.of(2015, 10, 1), LocalDate.of(2020, 5, 1), c1);
        AcademicExp ax2 = new AcademicExp(null, "ADS", "Fatec", FormationType.SUPERIOR, Degree.GRADUACAO, FormationStatus.COMPLETO, false, LocalDate.of(2015, 10, 1), LocalDate.of(2020, 5, 1), c2);
        AcademicExp ax3 = new AcademicExp(null, "Engenharia", "Usp", FormationType.MEDIO, Degree.GRADUACAO, FormationStatus.INCOMPLETO, false, LocalDate.of(2015, 10, 1), LocalDate.of(2020, 5, 1), c3);
        academicExpRepository.saveAll(Arrays.asList(ax1, ax2, ax3));

        Course course1 = new Course(null, TypeCourse.CURSO, "Java", "Curso avançado Java", c1);
        courseRepository.save(course1);

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

        Link link1 = new Link(null, "www.url.com.br", c3);
        Link link2 = new Link(null, "www.url.com.br", c3);
        Link link3 = new Link(null, "www.url.com.br", c3);
        Link link4 = new Link(null, "www.url.com.br", c2);
        linkRepository.saveAll(Arrays.asList(link1, link2, link3, link4));


        Project proj1 = new Project(null, "Java Project", "www.link.com.br", "Projeto em java", c2);
        Project proj2 = new Project(null, "Bank", "www.link.com.br", "Projeto desenvolvido em .NET", c1);
        Project proj3 = new Project(null, "Account Managment", "www.link.com.br", "Projeto legal", c3);


        Tool t1 = new Tool(null, "Java", c3);
        Tool t2 = new Tool(null, "Postman", c3);
        Tool t3 = new Tool(null, "Spring Boot", c3);
        Tool t4 = new Tool(null, "Angular", c3);

        toolRepository.saveAll(Arrays.asList(t1, t2, t3, t4));

        proj1.getTools().add(t1);
        proj1.getTools().add(t2);
        proj1.getTools().add(t3);
        proj1.getTools().add(t4);
        proj2.getTools().add(t1);

        projectRepository.saveAll(Arrays.asList(proj1, proj2, proj3));


    }
}
