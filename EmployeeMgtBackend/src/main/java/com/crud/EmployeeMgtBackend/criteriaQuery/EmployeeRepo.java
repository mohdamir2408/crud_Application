package com.crud.EmployeeMgtBackend.criteriaQuery;

import com.crud.EmployeeMgtBackend.entities.Employee;
import com.crud.EmployeeMgtBackend.entities.Pagination;
import com.crud.EmployeeMgtBackend.entities.ResponsePage;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo {

        public List<Employee> findByFirstName(String firstName);

//       public List<Employee> findAll();

        Employee findById(int id);

        Employee save(Employee employee);

        void delete(Employee employee);

        Employee update(Employee employeeDetails);

        ResponsePage paging(Pagination pagination);

        // Method for pagination
        // List<Employee> findAll(int offset, int limit);

        // List<Employee> findAllByPage(Pagination pagination);
}
