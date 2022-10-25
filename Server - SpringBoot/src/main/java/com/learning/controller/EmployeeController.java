package com.learning.controller;

import com.learning.model.Employee;
import com.learning.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    //get all emp
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
       return employeeRepo.findAll();
    }

    //create employee rest api
    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    //get employee by id rest api
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee>  getEmployeeById(@PathVariable Long id){
        Employee emp = employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee doesn't exist with id: "+id));
        return ResponseEntity.ok(emp);
    }

    //update employee rest api
    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee emp =employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee doesn't exist with id: "+id));
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmailId(employee.getEmailId());
        Employee updatedEmp =employeeRepo.save(emp);
        return ResponseEntity.ok(updatedEmp);
    }

    //delete employee rest api
    @DeleteMapping("employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee emp =employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee doesn't exist with id: "+id));
        employeeRepo.delete(emp);
        Map<String, Boolean> response =new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
