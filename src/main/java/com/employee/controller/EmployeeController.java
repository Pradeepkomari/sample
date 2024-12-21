package com.employee.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.exceptions.AgeException;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;

	@PostMapping("/add")
	public String add(@RequestBody Employee e) {
		return es.add(e);
	}

	@PostMapping("/addList")
	public String addList(@RequestBody List<Employee> e) {
		return es.addList(e);
	}

	@GetMapping("/getList")
	public List<Employee> get() {
		return es.get();
	}

	@GetMapping("/getList/{id}")
	public Employee getById(@PathVariable int id) {
		return es.getById(id);
	}

	@PutMapping("/update/{id}")
	public String updateById(@PathVariable int id, @RequestBody Employee e) {
		return es.updateById(id, e);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return es.deleteById(id);
	}

	@GetMapping("/maximum")
	public Employee getMaximum() {
		return es.getMaximum();
	}

	@GetMapping("/Secmaximum")
	public Employee getMaximumSec() {
		return es.getMaximumSec();
	}

	@GetMapping("/GetName")
	public List<String> getName() {
		return es.getName();
	}

	@GetMapping("/GetMinAge")
	public String getMinAge() {
		return es.getMinAge();
	}

	@GetMapping("/GetAge")
	public Set<Integer> getAge() {
		return es.getAge();
	}

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return es.getAll();
	}

	@GetMapping("/getByAge/{age}")
	public List<Employee> getByAge(@PathVariable int age) {
		return es.getByAge(age);
	}

	@GetMapping("/getByAge1/{age}")
	public List<Employee> getByExp(@PathVariable int age) {
		return es.getByExp(age);
	}

	/*
	 * @GetMapping("/getAge/{id}") public String getExp(@PathVariable int id)throws
	 * AgeException { return es.getExp(id); }
	 */

	@GetMapping("/getAge/{id}")
	public String getExp(@PathVariable int id) throws AgeException {
		return es.getExp(id);
	}

	@GetMapping("/getByName/{name}")
	public List<Employee> getByName(@PathVariable String name) throws AgeException {
		return es.getByName(name);
	}

}
