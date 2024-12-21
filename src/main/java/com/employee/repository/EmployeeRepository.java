package com.employee.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "Select * from employee", nativeQuery = true)
	public List<Employee> getAll();
	
	@Query(value = "Select * from employee where exp > ?",nativeQuery = true)
	public List<Employee> getByAge(int age);
		
	@Query(value = "SELECT a FROM Employee a WHERE a.exp >= :x")
	public List<Employee> getByExp(@Param("x") int exp);
	
	@Query(value = "SELECT * FROM employee  WHERE name like ?",nativeQuery = true)
	public List<Employee> getByName(String name);
	
	
	
}
