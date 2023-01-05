package com.crud.EmployeeMgtBackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "add_id")
    private Long addressId;
    private String city;
    private String zipCode;
    private String state;
    private String addressType;
    @ManyToOne()
    @Transient
    @JsonIgnore
    @JoinColumn( referencedColumnName = "empId")
    private Employee employee;


}