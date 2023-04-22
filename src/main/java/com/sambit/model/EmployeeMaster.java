package com.sambit.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:30 AM
 */

@Entity
@Table(name = "employee_master")
public class EmployeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Employee_Name", length = 50)
    private String employeeName;

    @Size(max = 50)
    @Column(name = "Employee_Phone", length = 50)
    private String employeePhone;

    @Size(max = 50)
    @Column(name = "Employee_Email", length = 50)
    private String employeeEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

}