package com.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.management.exception.*;
import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepo;
@CrossOrigin(origins  = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class EmployeeController {
    @Autowired
	private EmployeeRepo employeeRepo;
    
    //getall 
    @GetMapping("/employees")
    public  List<Employee> getAllEmployee(){
    	
		return employeeRepo.findAll();
    	
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
    	
    	return employeeRepo.save(employee);
    }
    
    @GetMapping("/employees/{id}")
     public Employee getEmployeeById(@PathVariable Long id) {
    	return employeeRepo.findById(id)
    			           .orElseThrow(()-> new userNotFoundException(id));
    }
    
    @PutMapping("/employees/{id}")
     public Employee updateEmployee(@RequestBody Employee newEmployee , @PathVariable Long id) {
    	 return employeeRepo.findById(id)
    			 .map(employee->{
    				  employee.setFirstName(newEmployee.getFirstName());
    				  employee.setLastName(newEmployee.getLastName());
    				  employee.setEmailId(newEmployee.getEmailId());
    				  return employeeRepo.save(employee);
    				  
    				 
    			 }).orElseThrow(()-> new userNotFoundException(id));
    }
   
  @DeleteMapping("/employees/{id}")
  public String  deleteEmployee(@PathVariable Long id) {
	   if(!employeeRepo.existsById(id)) {
		   throw new userNotFoundException(id);
	   }
	    employeeRepo.deleteById(id);
	    return "Employee with id"+id+" has been deleted";
  }
}
