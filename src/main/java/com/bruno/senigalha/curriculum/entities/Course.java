package com.bruno.senigalha.curriculum.entities;

import com.bruno.senigalha.curriculum.enums.TypeCourse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer typeCourse;
    private String title;
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public Course() {
    }

    public Course(Long id, TypeCourse typeCourse, String title, String description, Curriculum curriculum) {
        this.id = id;
        setTypeCourse(typeCourse);
        this.title = title;
        this.description = description;
        this.curriculum = curriculum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeCourse getTypeCourse(){
        return TypeCourse.valueOf(this.typeCourse);
    }

    public void setTypeCourse(TypeCourse typeCourse){
        this.typeCourse = typeCourse.getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
