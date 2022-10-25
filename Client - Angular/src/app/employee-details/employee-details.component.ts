import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id: number;
  employee: Employee =new Employee();

  constructor(private empService: EmployeeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id =this.route.snapshot.params['id'];
    this.empService.getEmployeeById(this.id).subscribe(data=>{
      this.employee =data;
    },error=> console.log(error));
  }

  employeeDetails(id: number){
    this.empService.getEmployeeById(id);
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

}
