package com.bruno.senigalha.curriculum.entities;

import com.bruno.senigalha.curriculum.enums.Degree;
import com.bruno.senigalha.curriculum.enums.FormationStatus;
import com.bruno.senigalha.curriculum.enums.FormationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_academic_experience")
public class AcademicExp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String institution;
    private int degree;
    private int formationType;
    private int formationStatus;
    private Boolean studying;
    private LocalDate startDate;
    private LocalDate endDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public AcademicExp() {
    }

    public AcademicExp(Long id, String courseName, String institution, FormationType formationType, Degree degree,
                       FormationStatus formationStatus, Boolean studying, LocalDate startDate, LocalDate endDate, Curriculum curriculum) {
        this.id = id;
        this.courseName = courseName;
        this.institution = institution;
        setFormationType(formationType);
        setDegree(degree);
        setFormationStatus(formationStatus);
        this.studying = studying;
        this.startDate = startDate;
        this.endDate = endDate;
        this.curriculum = curriculum;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Degree getDegree() {
        return Degree.valueOf(degree);
    }

    public void setDegree(Degree degree) {
        this.degree = degree.getCode();
    }

    public FormationStatus getFormationStatus() {
        return FormationStatus.valueOf(this.formationStatus);
    }

    public void setFormationStatus(FormationStatus formationStatus) {
        this.formationStatus = formationStatus.getCode();
    }

    public FormationType getFormationType() {
        return FormationType.valueOf(this.formationType);
    }

    public void setFormationType(FormationType formationType) {
        this.formationType = formationType.getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Boolean getStudying() {
        return studying;
    }

    public void setStudying(Boolean studying) {
        this.studying = studying;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicExp that = (AcademicExp) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
