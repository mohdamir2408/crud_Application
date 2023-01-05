package com.crud.EmployeeMgtBackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "emp_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "mobile_no")
    private String mobileNo;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_emp_id", referencedColumnName = "emp_id")
    private List<Address> addressList=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ds_id")
    private DS ds;


}
