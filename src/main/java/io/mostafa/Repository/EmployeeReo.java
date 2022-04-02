package io.mostafa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mostafa.Entity.Employee;

public interface EmployeeReo extends JpaRepository<Employee, Long> {

}
