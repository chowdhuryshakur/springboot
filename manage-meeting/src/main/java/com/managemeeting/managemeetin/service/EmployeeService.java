package com.managemeeting.managemeetin.service;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.Employee;
import com.managemeeting.managemeetin.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public  class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee insertEmployee(Employee employee) throws ResourceAlreadyExistsException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
        if(optionalEmployee.isPresent()){
            throw new ResourceAlreadyExistsException(employee.getEmployeeId() + "");
        }
        else{
            return employeeRepository.save(employee);
        }
    }

    public Employee updateEmployee (String employeeId, Employee employee) throws ResourceNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(optionalEmployee.isPresent()){
            employee.setEmployeeId(employeeId);
            return employeeRepository.save(employee);
        }
        else throw new ResourceNotFoundException(employeeId + "");
    }

    public Employee findById(String employeeId) throws ResourceNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else throw new ResourceNotFoundException(employeeId + "");
    }

    public List<Employee>findAll(){
        List<Employee>employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    public  boolean deleteById(String employeeId) throws ResourceNotFoundException{
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        optionalEmployee.ifPresent(employee -> employeeRepository.deleteById(employeeId));
        optionalEmployee.orElseThrow(() -> new ResourceNotFoundException(employeeId + ""));
        return true;
    }



}
