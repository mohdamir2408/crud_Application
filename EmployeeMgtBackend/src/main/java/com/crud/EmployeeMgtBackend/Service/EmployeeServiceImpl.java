package com.crud.EmployeeMgtBackend.Service;

import com.crud.EmployeeMgtBackend.criteriaQuery.EmployeeRepo;
import com.crud.EmployeeMgtBackend.criteriaQuery.EmployeeRepoImpl;
import com.crud.EmployeeMgtBackend.dto.EmployeeDto;
import com.crud.EmployeeMgtBackend.entities.Employee;
import com.crud.EmployeeMgtBackend.entities.Pagination;
import com.crud.EmployeeMgtBackend.entities.ResponsePage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDto convertToDTO(Employee emp) {
        return this.modelMapper.map(emp, EmployeeDto.class);
    }

    public Employee convertToEntity(EmployeeDto empDto) {
        return this.modelMapper.map(empDto, Employee.class);
    }

    //Service for Save...
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return this.convertToDTO(employeeRepo.save(this.convertToEntity(employeeDto)));
    }

    //Service for Find All...
//    @Override
//    public List<EmployeeDto> findAll() {
//        List<Employee> emps = employeeRepo.findAll();
//        List<EmployeeDto> empDtos = new ArrayList<>();
//        //Advance For Loop...
//        //for(Employee emp: emp) empDto.add(this.convertToDTO(emp));
//        //Basic For Loop...
//        for (Integer i = 0; i < emps.size(); i++) empDtos.add(this.convertToDTO(emps.get(i)));
//        return empDtos;
//    }

    //Service for Find By Id...
    // @Override
    public EmployeeDto findById(int id) {
        return this.convertToDTO(employeeRepo.findById(id));
    }

    //Service for Find By FirstName
    @Override
    public List<EmployeeDto> findByFirstName(String firstName) {
        List<Employee> emps = employeeRepo.findByFirstName(firstName);
        // Lambda expression in Java8..
        List<EmployeeDto> empDtos = emps.stream().map(emp -> this.convertToDTO(emp)).collect(Collectors.toList());
        return empDtos;
    }

    //Service for Delete...
    @Override
    public void delete(Integer id) {
        Employee emp=employeeRepo.findById(id);
        employeeRepo.delete(emp);
    }
    //Service for Update...
    @Override
    public EmployeeDto update(EmployeeDto employeeDetails) {
        return this.convertToDTO(employeeRepo.update(this.convertToEntity(employeeDetails)));
    }

    @Override
    public ResponsePage paging(Pagination pagination) {
        return null;
    }


    //Service for Sorting anf searching,sorting & Paging...
//    @Override
//    public List<EmployeeDto> findAllByPage(Pagination pagination) {
//        List<Employee> emps = employeeRepo.findAllByPage(pagination);
//        List<EmployeeDto> empDtos = new ArrayList<>();
//        for(Employee emp: emps) empDtos.add(this.convertToDTO(emp));
//        return empDtos;
//    }

}