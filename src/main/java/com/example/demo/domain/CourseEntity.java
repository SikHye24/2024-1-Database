package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

import java.util.Set;

@Entity
@Table(name = "COURSE")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CNO")
    private String cno;

    @Column(name = "CNAME")
    private String cname;

    @Column(name = "CREDIT")
    private Integer credit;

    @Column(name = "SESSIONS")
    private Integer sessions;

    @OneToMany(mappedBy = "course")
    private Set<EnrollEntity> enrolls;

    // getters and setters

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getSessions() {
        return sessions;
    }

    public void setSessions(Integer sessions) {
        this.sessions = sessions;
    }

    public Set<EnrollEntity> getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(Set<EnrollEntity> enrolls) {
        this.enrolls = enrolls;
    }
}