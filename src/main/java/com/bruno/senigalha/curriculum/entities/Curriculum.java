package com.bruno.senigalha.curriculum.entities;

import com.bruno.senigalha.curriculum.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_curriculum")
public class Curriculum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String picture;
    private String name;
    private Integer gender;
    private String professionalGoals;
    private String phone;
    private String email;
    private String linkedIn;

    @OneToOne(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private final Set<ProfessionalExp> professionalExperiences = new HashSet<>();

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private final Set<AcademicExp> academicExp = new HashSet<>();

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private final Set<Language> languages = new HashSet<>();

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private final Set<Link> links = new HashSet<>();

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private final Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private final Set<Tool> tools = new HashSet<>();

    public Curriculum() {
    }

    public Curriculum(Long id, String picture, String name, Gender gender, String professionalGoals, String phone, String email, String linkedIn) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        setGender(gender);
        this.professionalGoals = professionalGoals;
        this.phone = phone;
        this.email = email;
        this.linkedIn = linkedIn;
    }

    public Set<Tool> getTools() {
        return tools;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Set<AcademicExp> getAcademicExp() {
        return academicExp;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public Set<ProfessionalExp> getProfessionalExperiences() {
        return professionalExperiences;
    }

    public Set<Language> getLanguage() {
        return languages;
    }

    public Gender getGender() {
        return Gender.valueOf(gender);
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender.getCode();
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessionalGoals() {
        return professionalGoals;
    }

    public void setProfessionalGoals(String professionalGoals) {
        this.professionalGoals = professionalGoals;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curriculum that = (Curriculum) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
