package io.instacode.university.catalogue;

import io.instacode.university.models.BaseEntity;

import javax.persistence.*;

@Entity
public class Department extends BaseEntity {
    
    @Column(unique = true, length = 4)
    private String departmentCode;

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
