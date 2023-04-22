package com.sambit.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:25 AM
 */

@Entity
@Table(name = "batch_master")
public class BatchMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Batch_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Batch_Name", length = 50)
    private String batchName;

    @Column(name = "Batch_Start_Date")
    private LocalDate batchStartDate;

    @Column(name = "Batch_strength")
    private Integer batchStrength;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public LocalDate getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(LocalDate batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public Integer getBatchStrength() {
        return batchStrength;
    }

    public void setBatchStrength(Integer batchStrength) {
        this.batchStrength = batchStrength;
    }

}