package com.bruno.senigalha.curriculum.entities;

import com.bruno.senigalha.curriculum.enums.Proficiencylevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private Integer conversationLevel;
    private Integer comprehensionLevel;
    private Integer writingLevel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public Language() {
    }

    public Language(Long id, String language, Proficiencylevel conversationLevel, Proficiencylevel comprehensionLevel,
                    Proficiencylevel writingLevel, Curriculum curriculum) {
        this.id = id;
        this.language = language;
        setConversationLevel(conversationLevel);
        setComprehensionLevel(comprehensionLevel);
        setWritingLevel(writingLevel);
        this.curriculum = curriculum;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Proficiencylevel getConversationLevel() {
        return Proficiencylevel.valueOf(conversationLevel);
    }

    public void setConversationLevel(Proficiencylevel conversationLevel) {
        this.conversationLevel = conversationLevel.getCode();
    }

    public Proficiencylevel getComprehensionLevel() {
        return Proficiencylevel.valueOf(comprehensionLevel);
    }

    public void setComprehensionLevel(Proficiencylevel comprehensionLevel) {
        this.comprehensionLevel = comprehensionLevel.getCode();
    }

    public Proficiencylevel getWritingLevel() {
        return Proficiencylevel.valueOf(writingLevel);
    }

    public void setWritingLevel(Proficiencylevel writingLevel) {
        this.writingLevel = writingLevel.getCode();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(id, language.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
