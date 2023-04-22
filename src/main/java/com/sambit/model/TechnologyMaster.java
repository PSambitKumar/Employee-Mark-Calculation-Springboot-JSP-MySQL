package com.sambit.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:31 AM
 */

@Entity
@Table(name = "technology_master")
public class TechnologyMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Technology_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Teeechnology_Name", length = 50)
    private String teeechnologyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeeechnologyName() {
        return teeechnologyName;
    }

    public void setTeeechnologyName(String teeechnologyName) {
        this.teeechnologyName = teeechnologyName;
    }

}