package com.example.Spring_Jpa_assignment_2.inheritance;

import jakarta.persistence.*;

    @Entity
//    @DiscriminatorValue("PERMANENT")
    public class PermanentEmployee extends BaseEmployee {

        private Double salary;

        public Double getSalary() { return salary; }

        public void setSalary(Double salary) { this.salary = salary; }
    }