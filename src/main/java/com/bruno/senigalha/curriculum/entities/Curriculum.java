package com.bruno.senigalha.curriculum.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_curriculum")
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String picture;
    private String name;
    private String professionalGoals;
    private String phone;
    private String email;
    private String linkedIn;

    public Curriculum() {
    }

    public Curriculum(Long id, String picture, String name, String professionalGoals, String phone, String email, String linkedIn) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.professionalGoals = professionalGoals;
        this.phone = phone;
        this.email = email;
        this.linkedIn = linkedIn;
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
