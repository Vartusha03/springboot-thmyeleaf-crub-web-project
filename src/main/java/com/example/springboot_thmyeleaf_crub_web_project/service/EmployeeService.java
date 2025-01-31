package com.example.springboot_thmyeleaf_crub_web_project.service;


import com.example.springboot_thmyeleaf_crub_web_project.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Page<Employee> findPaginated(int pageNo, int pageSize,String sortField, String sortDirection);
}
