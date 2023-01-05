package com.crud.EmployeeMgtBackend.dto;

import com.crud.EmployeeMgtBackend.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DSDto {
    private Integer dsId;
    private String salary;
    private String designation;
    private Employee employee;

}
