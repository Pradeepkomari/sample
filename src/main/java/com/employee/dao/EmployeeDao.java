package com.employee.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository er;

	public String add(Employee e) {
		er.save(e);
		return "Stored";
	}

	public String addList(List<Employee> e) {
		er.saveAll(e);
		return "Stored";
	}

	public List<Employee> get() {
		return er.findAll();
	}

	public Employee getById(int id) {
		return er.findById(id).get();
	}
	public String updateById(int id , Employee e) {
		er.save(e);
		return "Updated";
	}
	public String deleteById(int id) {
		er.deleteById(id);
		return "Deleted";
	}
	
	public List<Employee> getAll(){
		return er.getAll();
	}
	
	public List<Employee> getByAge(int age) {
		return er.getByAge(age);
	}
	
	public List<Employee> getByExp(int age) {
		return er.getByExp(age);
	}
	

	public Employee getExp(int id) {
		return er.findById(id).get();
	}
	
	public List<Employee> getByName(String name) {
		return er.getByName(name);
	}
	
	

}
