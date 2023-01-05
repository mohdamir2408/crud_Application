package com.crud.EmployeeMgtBackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ds_id")
    private Integer dsId;
    private String salary;
    private String designation;
    @OneToOne()
    @JsonIgnore
    private Employee employee;
}
