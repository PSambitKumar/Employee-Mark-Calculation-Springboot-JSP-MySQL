package com.sambit.repository;

import com.sambit.model.AssementMark;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:31 AM
 */

public interface AssementMarkRepository extends JpaRepository<AssementMark, Integer> {
}