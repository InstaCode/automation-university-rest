package io.instacode.university.database.catalogue;

import io.instacode.university.database.BaseEntity;

import javax.persistence.*;

@Entity
public class Course extends BaseEntity {


    @ManyToOne(optional = false)
    @JoinColumn(name = "department_code", nullable = false)
    private Department department;

    private String courseName;

    private int credits;

    private String courseDescription;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseDescription() {
        return this.courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
