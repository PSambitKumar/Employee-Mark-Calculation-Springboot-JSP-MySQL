package com.sambit.repository;

import com.sambit.model.BatchAllocate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : EmpSalary
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:31 AM
 */

public interface BatchAllocateRepository extends JpaRepository<BatchAllocate, Integer> {
}