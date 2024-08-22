package com.bruno.senigalha.curriculum.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_link")
public class Link implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String link;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public Link() {
    }

    public Link(Long id, String link, Curriculum curriculum) {
        this.id = id;
        this.link = link;
        this.curriculum = curriculum;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(id, link.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
