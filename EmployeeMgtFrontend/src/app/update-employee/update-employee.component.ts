import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../employee';
import { Address } from '../address';
import { DS } from '../ds';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
}) 
export class UpdateEmployeeComponent implements OnInit {

  id: number;
  employee: Employee=new Employee();
  add:Address=new Address();
  dataarray:Address[]=[];
  post:DS=new DS();
  
  constructor(private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      this.employee=new Employee();
      this.employeeService.getEmployeeById(this.id).subscribe({next:(data:any) => {
        this.employee = data;
        this.dataarray=this.employee.addressList;
        this.post=this.employee.ds;
        console.log(this.employee);
      },error:(error:any)=>{
        console.log(error);
      }
      });
      
    }

    addForm(){
      this.add= new Address()
      this.dataarray.push(this.add);
    }
  
    removeForm(index:any){
      this.dataarray.splice(index,1);
    }

  onSubmit(){
    this.employee.addressList=this.dataarray;
    this.employee.ds=this.post;
    this.employeeService.updateEmployee(this.employee).subscribe( data =>{
      this.router.navigate(['/employees']);
    },
     error => console.log(error));
  }
}