package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "LECTURE")
public class LectureEntity {

    @Id
    @Column(name = "CNO")
    private String cno;

    @Column(name = "PNO")
    private Long pno;

    @Column(name = "LEC_TIME")
    private String lecTime;

    @Column(name = "ROOM")
    private String room;

    @ManyToOne
    @JoinColumn(name = "PNO", insertable = false, updatable = false)
    private ProfessorEntity professor;

    // getters and setters

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Long getPno() {
        return pno;
    }

    public void setPno(Long pno) {
        this.pno = pno;
    }

    public String getLecTime() {
        return lecTime;
    }

    public void setLecTime(String lecTime) {
        this.lecTime = lecTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }
}