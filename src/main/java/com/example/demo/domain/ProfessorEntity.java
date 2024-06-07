package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PROFESSOR")
public class ProfessorEntity {

    @Id
    @Column(name = "PNO")
    private Long pno;

    @Column(name = "PNAME")
    private String pname;

    @Column(name = "PMAJOR")
    private String pmajor;

    @Column(name = "PDEPT")
    private String pdept;

    @OneToMany(mappedBy = "professor")
    private Set<LectureEntity> lectures;

    // getters and setters

    public Long getPno() {
        return pno;
    }

    public void setPno(Long pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPmajor() {
        return pmajor;
    }

    public void setPmajor(String pmajor) {
        this.pmajor = pmajor;
    }

    public String getPdept() {
        return pdept;
    }

    public void setPdept(String pdept) {
        this.pdept = pdept;
    }

    public Set<LectureEntity> getLectures() {
        return lectures;
    }

    public void setLectures(Set<LectureEntity> lectures) {
        this.lectures = lectures;
    }
}