
  import { Component, OnInit } from '@angular/core';
  import { Employee } from '../employee';
  import { EmployeeService } from '../services/employee.service';
  import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{
[x: string]: any;
  employees: Employee[]=[];
  constructor(private employeeService: EmployeeService,
    private router: Router){}
  

  ngOnInit(): void {
    this.getEmployees();
  }
  private getEmployees() {
    this.employeeService.getEmployeeList().subscribe(data=>{
      if(data){
        this.employees = data;
        console.log(this.employees,"emp")
      }
     

      console.log(data);
    });
  }
  employeeDetails(id: number){
    this.router.navigate(['employee-details', id]);
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: number){
    this.employeeService.deleteEmployee(id).subscribe( data => {
      console.log(data);
      this.getEmployees();
   });
  }
}
