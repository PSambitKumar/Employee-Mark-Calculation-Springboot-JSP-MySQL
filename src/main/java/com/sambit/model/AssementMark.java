package com.sambit.model;

import javax.persistence.*;

/**
 * @Project : EmpSalary
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:20 AM
 */

@Entity
@Table(name = "assement_mark")
public class AssementMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slno", nullable = false)
    private Integer id;

    @Column(name = "empid")
    private Integer empid;

    @Column(name = "mark")
    private Integer mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

}