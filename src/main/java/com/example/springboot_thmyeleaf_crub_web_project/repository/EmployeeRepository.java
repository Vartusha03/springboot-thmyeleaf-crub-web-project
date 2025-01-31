package com.example.springboot_thmyeleaf_crub_web_project.repository;

import com.example.springboot_thmyeleaf_crub_web_project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
