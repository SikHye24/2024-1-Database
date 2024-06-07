package com.example.demo.service;

import com.example.demo.domain.EnrollEntity;
import com.example.demo.domain.StudentEntity;
import com.example.demo.repository.EnrollRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollRepository enrollRepository;

    public List<EnrollEntity> getEnrollsByStudentId(Long studentId) {
        return enrollRepository.findAll().stream()
                .filter(enroll -> enroll.getSno().equals(studentId))
                .collect(Collectors.toList());
    }

    public List<EnrollEntity> getIncorrectGrades() {
        return enrollRepository.findAll().stream()
                .filter(enroll -> !enroll.getGrade().equals(calculateGrade(enroll.getExam())))
                .peek(enroll -> enroll.setCorrectGrade(calculateGrade(enroll.getExam())))
                .collect(Collectors.toList());
    }

    public void updateGrade(Long sno, String cno, String correctGrade) {
        EnrollEntity enroll = enrollRepository.findBySnoAndCno(sno, cno);
        enroll.setGrade(correctGrade);
        enrollRepository.save(enroll);
    }

    //학점 계산
    private String calculateGrade(String examScoreStr) {
        int examScore = Integer.parseInt(examScoreStr);
        if (examScore < 60) {
            return "F";
        } else if (examScore < 70) {
            return "D";
        } else if (examScore < 80) {
            return "C";
        } else if (examScore < 90) {
            return "B";
        } else {
            return "A";
        }
    }

    public Map<String, EnrollEntity> getHighestScorers() {
        return enrollRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        EnrollEntity::getCno,
                        Collectors.collectingAndThen(
                                Collectors.maxBy((e1, e2) -> Integer.compare(Integer.parseInt(e1.getExam()), Integer.parseInt(e2.getExam()))),
                                opt -> opt.orElse(null)
                        )
                ));
    }

    public Map<String, EnrollEntity> getLowestScorers() {
        return enrollRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        EnrollEntity::getCno,
                        Collectors.collectingAndThen(
                                Collectors.minBy((e1, e2) -> Integer.compare(Integer.parseInt(e1.getExam()), Integer.parseInt(e2.getExam()))),
                                opt -> opt.orElse(null)
                        )
                ));
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Map<Long, StudentStatistics> getStudentStatistics() {
        List<StudentEntity> students = studentRepository.findAll();

        return students.stream().collect(Collectors.toMap(
                StudentEntity::getSno,
                student -> {
                    List<EnrollEntity> enrolls = enrollRepository.findBySno(student.getSno());
                    int totalCredits = enrolls.stream()
                            .mapToInt(enroll -> enroll.getCourse().getCredit())
                            .sum();
                    double averageExamScore = enrolls.stream()
                            .mapToInt(enroll -> Integer.parseInt(enroll.getExam()))
                            .average()
                            .orElse(0);
                    return new StudentStatistics(totalCredits, averageExamScore);
                }
        ));
    }

    public static class StudentStatistics {
        private final int totalCredits;
        private final double averageExamScore;

        public StudentStatistics(int totalCredits, double averageExamScore) {
            this.totalCredits = totalCredits;
            this.averageExamScore = averageExamScore;
        }

        public int getTotalCredits() {
            return totalCredits;
        }

        public double getAverageExamScore() {
            return averageExamScore;
        }
    }

    public Map<String, CourseStatistics> getCourseStatistics() {
        List<EnrollEntity> enrolls = enrollRepository.findAll();

        return enrolls.stream()
                .collect(Collectors.groupingBy(
                        EnrollEntity::getCno,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                this::calculateCourseStatistics
                        )
                ));
    }

    private CourseStatistics calculateCourseStatistics(List<EnrollEntity> enrolls) {
        double averageScore = enrolls.stream()
                .mapToInt(enroll -> Integer.parseInt(enroll.getExam()))
                .average()
                .orElse(0);

        Map<String, Long> gradeCounts = enrolls.stream()
                .collect(Collectors.groupingBy(
                        EnrollEntity::getGrade,
                        Collectors.counting()
                ));

        return new CourseStatistics(averageScore, gradeCounts);
    }

    public static class CourseStatistics {
        private final double averageScore;
        private final Map<String, Long> gradeCounts;

        public CourseStatistics(double averageScore, Map<String, Long> gradeCounts) {
            this.averageScore = averageScore;
            this.gradeCounts = gradeCounts;
        }

        public double getAverageScore() {
            return averageScore;
        }

        public Map<String, Long> getGradeCounts() {
            return gradeCounts;
        }
    }

    //학과별, 학년별 총 학생수 확인
    public Map<String, Long> getStudentCountByDept() {
        List<StudentEntity> students = studentRepository.findAll();

        return students.stream()
                .collect(Collectors.groupingBy(
                        StudentEntity::getDept,
                        Collectors.counting()
                ));
    }

    public Map<Integer, Long> getStudentCountByYear() {
        List<StudentEntity> students = studentRepository.findAll();

        return students.stream()
                .collect(Collectors.groupingBy(
                        StudentEntity::getYear,
                        Collectors.counting()
                ));
    }

    public Map<String, Map<Integer, Long>> getStudentCountByDeptAndYear() {
        List<StudentEntity> students = studentRepository.findAll();

        return students.stream()
                .collect(Collectors.groupingBy(
                        StudentEntity::getDept,
                        Collectors.groupingBy(
                                StudentEntity::getYear,
                                Collectors.counting()
                        )
                ));
    }

}