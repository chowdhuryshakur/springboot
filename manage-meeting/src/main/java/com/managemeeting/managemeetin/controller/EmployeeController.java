package com.managemeeting.managemeetin.controller;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.Employee;
import com.managemeeting.managemeetin.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getEmployee(){
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String employeeId){
        try{
            Employee employee = employeeService.findById(employeeId);
            return ResponseEntity.ok(employee);}
        catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception f){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public  ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
        try{
            Employee insertEmployee = employeeService.insertEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertEmployee);}
        catch (ResourceAlreadyExistsException e) {return ResponseEntity.badRequest().body(null);}

    }

    @PutMapping("/{employeeId}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee){
        try{
            Employee updateEmployee = employeeService.updateEmployee(employeeId, employee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateEmployee);}
        catch (ResourceNotFoundException e) {return ResponseEntity.badRequest().body(null);}

    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId){
        try{
            boolean deletedEmployee = employeeService.deleteById(employeeId);
            return ResponseEntity.ok(employeeId);}
        catch (ResourceNotFoundException e){return ResponseEntity.notFound().build();}
    }


}
