package com.crud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository sr;

	public String post(Student s) {
		sr.save(s);
		return "Posted";
	}

	public String postList(List<Student> s) {
		sr.saveAll(s);
		return "Posted";
	}

	public List<Student> getAll() {
		return sr.findAll();
	}

	public Student getId(Integer id) {

		return sr.findById(id).get();
	}

	public String deleteById(@PathVariable int id) {
		sr.deleteById(id);
		return "Deleted";
	}

	public String update(@PathVariable int id, @RequestBody Student s) {
		sr.save(s);
		return "Updated";
	}

}
