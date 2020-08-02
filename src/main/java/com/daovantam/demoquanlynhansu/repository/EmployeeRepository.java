package com.daovantam.demoquanlynhansu.repository;

import com.daovantam.demoquanlynhansu.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
