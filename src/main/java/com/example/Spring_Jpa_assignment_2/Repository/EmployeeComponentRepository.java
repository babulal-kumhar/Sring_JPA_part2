package com.example.Spring_Jpa_assignment_2.Repository;

import com.example.Spring_Jpa_assignment_2.component.EmployeeComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeComponentRepository extends JpaRepository<EmployeeComponent, Long> {}