package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "ENROLL")
public class EnrollEntity {

    @Id
    @Column(name = "SNO")
    private Long sno;

    @Column(name = "CNO")
    private String cno;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "EXAM")
    private String exam;

    @Transient
    private String correctGrade;

    @ManyToOne
    @JoinColumn(name = "SNO", insertable = false, updatable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "CNO", insertable = false, updatable = false)
    private CourseEntity course;

    // getters and setters

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getCorrectGrade() {
        return correctGrade;
    }

    public void setCorrectGrade(String correctGrade) {
        this.correctGrade = correctGrade;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }
}