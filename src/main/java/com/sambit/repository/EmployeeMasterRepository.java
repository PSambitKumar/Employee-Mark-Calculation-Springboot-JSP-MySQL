package com.sambit.repository;

import com.sambit.model.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:31 AM
 */

public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, Integer> {
    @Query(value =
            "SELECT em.Employee_id, em.Employee_Name\n" +
            "FROM Employee_Master em\n" +
            "INNER JOIN Batch_Allocate ba ON em.Employee_id = ba.Employee_id\n" +
            "WHERE ba.Batch_id = ?1\n" +
            "  AND ba.Technology_id = ?2\n", nativeQuery = true)
    List<Object[]> getEmployeeMasterByBatchIdAndTechnologyId(int batchId, int technologyId);
}