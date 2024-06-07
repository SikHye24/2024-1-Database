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
@Table(name = "STUDENT")
public class StudentEntity {

    @Id
    @Column(name = "SNO")
    private Long sno;

    @Column(name = "PNO")
    private Long pno;

    @Column(name = "SNAME")
    private String sname;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "DEPT")
    private String dept;

    // getters and setters

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public Long getPno() {
        return pno;
    }

    public void setPno(Long pno) {
        this.pno = pno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}