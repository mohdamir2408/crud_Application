import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private url = "http://localhost:8080/api/employees"

  constructor( private httpClient: HttpClient) { }

  //Service For Get Employee
  getEmployeeList(): Observable<any>
  {
    return this.httpClient.get<any>('http://localhost:8080/api/employees') ;
  }

  //Service For Get Employee By Id localhost:8080/api/employeeById?id=3
  getEmployeeById(id:number): Observable<any>
  {
    return this.httpClient.get<any>(`http://localhost:8080/api/employeeById?id=${id}`) ;
  }

  //Service For Create Employee
  createEmployee(employee: Employee ): Observable<Employee[]>
  {
    return this.httpClient.post<Employee[]>(`${this.url}/save`, employee) ;
  }

  //Service For Update Employee
  updateEmployee(employee: Employee ): Observable<any>
  {
    return this.httpClient.put<any>('http://localhost:8080/api/updateEmployee', employee) ;
  }

  //Service For Delete Employee
  deleteEmployee(id: number ): Observable<any>
  {
    return this.httpClient.delete<any>(`${this.url}/${id}`) ;
  }

}
