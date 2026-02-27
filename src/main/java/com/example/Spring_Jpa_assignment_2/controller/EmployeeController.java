package com.example.Spring_Jpa_assignment_2.controller;

import com.example.Spring_Jpa_assignment_2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpql")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // 1️⃣ Employees above average salary
    @GetMapping("/above-average")
    public List<Object[]> getAboveAverage() {
        return service.getAboveAverage();
    }

    // 2️⃣ Update salary below average
    @PutMapping("/update-below-average")
    public String updateBelowAverage(@RequestParam Double salary) {
        int updated = service.updateBelowAverage(salary);
        return updated + " rows updated";
    }



    // 3️⃣ Delete minimum salary employees
    @DeleteMapping("/delete-min-salary")
    public String deleteMinSalary() {
        int deleted = service.deleteMinSalary();
        return deleted + " rows deleted";
    }

    @GetMapping("/ends-with")
    public List<Object[]> findByLastName(@RequestParam String suffix) {
        return service.findEmployeesEndingWith(suffix);
    }

    @DeleteMapping("/delete-age")
    public String deleteByAge(@RequestParam int age) {
        int deleted = service.deleteEmployeesAboveAge(age);
        return deleted + " rows deleted";
    }
}