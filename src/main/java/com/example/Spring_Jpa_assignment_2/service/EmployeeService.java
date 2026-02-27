package com.example.Spring_Jpa_assignment_2.service;

import com.example.Spring_Jpa_assignment_2.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // 1️⃣ Read query (no transaction required)
    public List<Object[]> getAboveAverage() {
        return repository.findEmployeesAboveAverage();
    }

    // 2️⃣ Update query (transaction required)
    @Transactional
    public int updateBelowAverage(Double newSalary) {

        Double avg = repository.findAverageSalary();

        return repository.updateSalaryBelowAverage(newSalary, avg);
    }

    // 3️⃣ Delete query (transaction required)
    @Transactional
    public int deleteMinSalary() {
        Double minSalary = repository.findMinSalary();
        if (minSalary == null) {
            return 0;
        }
        return repository.deleteBySalary(minSalary);
    }
    // 1️⃣ Find employees where last name ends with suffix
    public List<Object[]> findEmployeesEndingWith(String suffix) {
        return repository.findEmployeesEndingWith(suffix);
    }

    // 2️⃣ Delete employees age greater than
    @Transactional
    public int deleteEmployeesAboveAge(int age) {
        return repository.deleteEmployeesAboveAge(age);
    }
}