package com.sambit.model;

import java.util.Date;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 11:06 AM
 */
public class TableListDTO {
    private int slNo;
    private String batchName;
    private String batchStartDate;
    private String technologyName;
    private String employeeName;
    private String employeePhone;
    private Integer mark;
    private String grade;
    private String status;

    public int getSlNo() {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(String batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TableListDTO{" +
                "slNo=" + slNo +
                ", batchName='" + batchName + '\'' +
                ", batchStartDate='" + batchStartDate + '\'' +
                ", technologyName='" + technologyName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", mark=" + mark +
                ", grade=" + grade +
                ", status='" + status + '\'' +
                '}';
    }
}
