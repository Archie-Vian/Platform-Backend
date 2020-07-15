package ru.studentsplatform.backend.entities.model;

import org.hibernate.annotations.GeneratorType;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "student_council")
public class StudentCouncil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_council_id")
    private Long student;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "audience",nullable = false)
    private String audience;

    @Column(name = "vk_group",nullable = false)
    private String vkGroup;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
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

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getVkGroup() {
        return vkGroup;
    }

    public void setVkGroup(String vkGroup) {
        this.vkGroup = vkGroup;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
