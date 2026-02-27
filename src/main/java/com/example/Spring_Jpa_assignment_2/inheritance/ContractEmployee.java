package com.example.Spring_Jpa_assignment_2.inheritance;

import jakarta.persistence.*;

@Entity
//@DiscriminatorValue("CONTRACT")
public class ContractEmployee extends BaseEmployee {

    private Double hourlyRate;

    public Double getHourlyRate() { return hourlyRate; }

    public void setHourlyRate(Double hourlyRate) { this.hourlyRate = hourlyRate; }
}