package bd.edu.seu.managemeeting.controller;

import bd.edu.seu.managemeeting.exception.ResourceNotFoundException;
import bd.edu.seu.managemeeting.service.EmployeeService;
import bd.edu.seu.managemeeting.exception.ResourceAlreadyExistsException;
import bd.edu.seu.managemeeting.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getEmployee(){
        logger.trace("getEmployee method called.");
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String employeeId){
        logger.trace("getEmployeeById method called.");
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
        logger.trace("insertEmployee method called.");
        try{
            Employee insertEmployee = employeeService.insertEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertEmployee);}
        catch (ResourceAlreadyExistsException e) {return ResponseEntity.badRequest().body(null);}

    }
    @PutMapping("/{employeeId}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee){
        logger.trace("updateEmployee method called.");
        try{
            Employee updateEmployee = employeeService.updateEmployee(employeeId, employee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateEmployee);}
        catch (ResourceNotFoundException e) {return ResponseEntity.badRequest().body(null);}

    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId){
        logger.trace("Delete Employee method called.");
        try{
            boolean deletedEmployee = employeeService.deleteById(employeeId);
            return ResponseEntity.ok(employeeId);}
        catch (ResourceNotFoundException e){return ResponseEntity.notFound().build();}
    }


}