package com.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.exceptions.AgeException;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao ed;

	public String add(Employee e) {
		return ed.add(e);
	}

	public String addList(List<Employee> e) {
		return ed.addList(e);
	}

	public List<Employee> get() {
		return ed.get();
	}

	public Employee getById(int id) {
		return ed.getById(id);
	}

	public String updateById(int id, Employee e) {
		return ed.updateById(id, e);
	}

	public String deleteById(int id) {
		return ed.deleteById(id);
	}

	public Employee getMaximum() {
		List<Employee> emp = ed.get();
		Employee max = emp.get(0);
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i).getSalary() > max.getSalary()) {
				max = emp.get(i);
			}
		}

		return max;
	}

	public Employee getMaximumSec() {

		List<Employee> emp = ed.get();
		Employee max = emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst()
				.get();
		/*
		 * List<Integer> max = emp.stream().map(x ->
		 * x.getSalary()).sorted(Collections.reverseOrder()).limit(2).skip(1)
		 * .collect(Collectors.toList());
		 */
		return max;
	}

	public List<String> getName() {
		List<Employee> emp = ed.get();
		List<String> name = emp.stream().map(x -> x.getName()).filter(x -> x.length() < 5).collect(Collectors.toList());
		return name;

	}

	public String getMinAge() {
		List<Employee> emp = ed.get();
		Employee min = emp.get(0);
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i).getExp() < min.getExp()) {
				min = emp.get(i);
			}
		}
		return min.getName() + " " + min.getExp();
	}

	public Set<Integer> getAge() {
		List<Employee> emp = ed.get();
		Set<Integer> age = emp.stream().map(x -> x.getExp()).collect(Collectors.toSet());
		return age;
	}

	public List<Employee> getAll() {
		return ed.getAll();
	}

	public List<Employee> getByAge(int age) {
		return ed.getByAge(age);
	}

	public List<Employee> getByExp(int age) {
		return ed.getByExp(age);
	}

	public String getExp(int id) throws AgeException {
		Employee emp = ed.getExp(id);
		if (emp.getExp() > 8) {
			return emp.getExp()+ "";
		} else {
			throw new AgeException("EXP LESS THAN 8");
		}
	}

	/*
	 * public String getExp(int id) { Employee emp = ed.getExp(id);
	 * 
	 * try { if (emp.getExp() > 8) { return emp.getExp() + ""; } else { throw new
	 * AgeException("EXP LESS THAN 8"); } } catch (AgeException e) { return
	 * e.getMessage();
	 * 
	 * }
	 * 
	 * }
	 */

	public List<Employee> getByName(String name) throws AgeException {
		if (ed.getByName(name).isEmpty()) {
			throw new AgeException("");
		}
		return ed.getByName(name);
	}

}
