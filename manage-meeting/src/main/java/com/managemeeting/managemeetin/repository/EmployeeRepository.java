package com.managemeeting.managemeetin.repository;

import com.managemeeting.managemeetin.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
