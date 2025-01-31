package com.example.springboot_thmyeleaf_crub_web_project.service;

import com.example.springboot_thmyeleaf_crub_web_project.model.Employee;
import com.example.springboot_thmyeleaf_crub_web_project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
       this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id){
        Employee employee = employeeRepository.findById(id).get();
        return employee;
//        Optional<Employee> optional = employeeRepository.findById(id);
//        Employee employee = null;
//        if(optional.isPresent()){
//            employee = optional.get();
//        }else{
//            throw new RuntimeException("Employee not found by id:"+ id);
//        }
//            return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize,String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }
}
