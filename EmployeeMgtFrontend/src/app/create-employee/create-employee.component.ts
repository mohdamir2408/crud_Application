import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Address } from '../address';
import { EmployeeService } from '../services/employee.service';
import { Router } from '@angular/router';
import { DS } from '../ds';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit{
  employee:Employee = new Employee();
  add:Address=new Address();
  dataarray:Address[]=[];
  post:DS=new DS();
  constructor(private employeeService: EmployeeService, private router:Router){}


  ngOnInit(): void {
    console.log(this.employee,"empl");
    this.dataarray.push(this.add);
  }
 
  addForm(){
    this.add= new Address()
    this.dataarray.push(this.add);
  }

  removeForm(index:any){
    this.dataarray.splice(index,1);
  }
  

  saveEmployee(){
    this.employee.ds=this.post;
    this.employee.addressList=this.dataarray;
    this.employeeService.createEmployee(this.employee).subscribe(data =>{
      console.log(data); 
    },
    error => console.log(error));
    
  }

  

  goToEmployeeList()
  {
    this.router.navigate(['/employees']);
  }
  
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
  submitted =false;
  

}


