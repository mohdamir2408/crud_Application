package com.crud.EmployeeMgtBackend.ValidatorInterface;

import com.crud.EmployeeMgtBackend.controller.EmployeeController;
import com.crud.EmployeeMgtBackend.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = EmployeeController.class)

    public class EmployeeValidator implements Validator {
        @Override
        public boolean supports(Class<?> clazz) {
            return Employee.class.equals(clazz);
        }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee=(Employee) target;

//        String FirstName= employee.getFirstName();
//        String LastName= employee.getLastName();
//        String MobileNo= employee.getMobileNo();



            if(employee.getFirstName()==null || employee.getFirstName().length()<3){
                errors.rejectValue("firstName","1jsj","First name must be at least three or more Characters");
            }
            if(employee.getLastName()==null || employee.getLastName().length()<3){
                errors.rejectValue("lastName","11hka","Last name must be at least three or more Characters");
            }
            if(employee.getMobileNo()==null ){ //|| employee.getMobileNo().matches("[6-9][0-9]{9}")
                errors.rejectValue("mobile","8x68s", "Mobile number must be valid");
            }
            if(employee.getEmailId()==null){
                errors.rejectValue("emailId","cdr45","Email Id must not be null");
            }


        }

    }