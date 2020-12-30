package io.instacode.university.database.catalogue;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @Column(unique = true, length = 4)
    private String departmentCode;

    @OneToMany(targetEntity = io.instacode.university.database.catalogue.Course.class)
    private List<Course> courses;

    private String departmentName;

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
