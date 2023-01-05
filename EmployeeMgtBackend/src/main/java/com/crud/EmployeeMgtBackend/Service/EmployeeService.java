package com.crud.EmployeeMgtBackend.Service;

import com.crud.EmployeeMgtBackend.dto.EmployeeDto;
import com.crud.EmployeeMgtBackend.entities.Employee;
import com.crud.EmployeeMgtBackend.entities.Pagination;
import com.crud.EmployeeMgtBackend.entities.ResponsePage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public EmployeeDto saveEmployee(EmployeeDto employeeDto);
//    public List<EmployeeDto> findAll();

    public EmployeeDto findById(int id);
    List<EmployeeDto> findByFirstName(String firstName);
    void delete(Integer id);
    EmployeeDto update(EmployeeDto employeeDetails);

//    List<EmployeeDto> findAllByPage(Pagination pagination);

    ResponsePage paging(Pagination pagination);
}
