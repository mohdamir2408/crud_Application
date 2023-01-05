package com.crud.EmployeeMgtBackend.dto;

import com.crud.EmployeeMgtBackend.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressDto {
    private Long addressId;
    private String city;
    private String zipCode;
    private String state;
    private String addressType;
    private Employee employee;
}
