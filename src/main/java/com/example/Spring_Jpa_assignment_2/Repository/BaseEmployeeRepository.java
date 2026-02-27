package com.example.Spring_Jpa_assignment_2.Repository;

import com.example.Spring_Jpa_assignment_2.inheritance.BaseEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEmployeeRepository extends JpaRepository<BaseEmployee, Long> {}
