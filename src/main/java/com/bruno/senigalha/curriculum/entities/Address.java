package com.bruno.senigalha.curriculum.entities;

import com.bruno.senigalha.curriculum.repositories.CurriculumRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String zipCode;
    private String city;
    private String country;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public Address() {
    }

    public Address(Long id, String zipCode, String city, String country, Curriculum curriculum) {
        this.id = id;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.curriculum = curriculum;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
