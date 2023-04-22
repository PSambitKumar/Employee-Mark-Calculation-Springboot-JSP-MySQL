package com.sambit.repository;

import com.sambit.model.BatchMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:31 AM
 */

public interface BatchMasterRepository extends JpaRepository<BatchMaster, Integer> {

    @Query(value = "SELECT bm.Batch_Name, bm.Batch_Start_Date, tm.Teeechnology_Name, em.Employee_Name, em.Employee_Phone, am.mark\n" +
            "FROM Batch_Master bm\n" +
            "         JOIN Batch_Allocate ba ON bm.Batch_id = ba.Batch_id\n" +
            "         JOIN Technology_Master tm ON ba.Technology_id = tm.Technology_id\n" +
            "         JOIN Employee_Master em ON ba.Employee_id = em.Employee_id\n" +
            "         JOIN Assement_Mark am ON em.Employee_id = am.empid", nativeQuery = true)
    List<Object[]> getTableList();

    @Query(value = "SELECT bm.Batch_Name, bm.Batch_Start_Date, tm.Teeechnology_Name, em.Employee_Name, em.Employee_Phone, am.mark\n" +
            "FROM Batch_Master bm\n" +
            "         JOIN Batch_Allocate ba ON bm.Batch_id = ba.Batch_id\n" +
            "         JOIN Technology_Master tm ON ba.Technology_id = tm.Technology_id\n" +
            "         JOIN Employee_Master em ON ba.Employee_id = em.Employee_id\n" +
            "         JOIN Assement_Mark am ON em.Employee_id = am.empid\n" +
            "where bm.Batch_id = ?1", nativeQuery = true)
    List<Object[]> getTableListByBatchId(int batchId);
}