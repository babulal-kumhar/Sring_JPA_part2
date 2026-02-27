package com.example.Spring_Jpa_assignment_2.Repository;

import com.example.Spring_Jpa_assignment_2.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("""
    SELECT e.firstName, e.lastName
    FROM Employee e
    WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)
    ORDER BY e.age ASC, e.salary DESC
    """)
    List<Object[]> findEmployeesAboveAverage();

    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double findAverageSalary();

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.salary = :newSalary WHERE e.salary < :avgSalary")
    int updateSalaryBelowAverage(@Param("newSalary") Double newSalary,
                                 @Param("avgSalary") Double avgSalary);


    @Query("SELECT MIN(e.salary) FROM Employee e")
    Double findMinSalary();
    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.salary = :minSalary")
    int deleteBySalary(@Param("minSalary") Double minSalary);

    @Query(value = """
    SELECT emp_id, emp_first_name, emp_age
    FROM employee_table
    WHERE emp_last_name LIKE %:suffix
    """, nativeQuery = true)
    List<Object[]> findEmployeesEndingWith(@Param("suffix") String suffix);

    @Modifying
    @Transactional
    @Query(value = """
    DELETE FROM employee_table
    WHERE emp_age > :age
    """, nativeQuery = true)
    int deleteEmployeesAboveAge(@Param("age") int age);


}
