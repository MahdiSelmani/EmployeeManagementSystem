import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL ="http://localhost:8080/api/v1/employees";
  constructor(private httpClient: HttpClient) {}

  getEmployeeList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  createEmployee(employee: Employee): Observable<any>{
    return this.httpClient.post(`${this.baseURL}`,employee);
  }

  updateEmployee(id: number, emp: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,emp);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  // employeeDetails(id: number): Observable<Employee>{
  //   return this.httpClient.get(`${this.baseURL}/${id}`);
  // }
}
