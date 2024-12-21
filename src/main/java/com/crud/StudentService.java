package com.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {
	@Autowired
	StudentDao sd;
	
	public String post(Student s) {
		return sd.post(s);
	}
	
	public String postList(List<Student> s) {
		return sd.postList(s);
	}
	
	public List<Student> getAll(){
		return sd.getAll();
	}
	
	public Student getId(Integer id) {
		return sd.getId(id);
	}
	public String deleteById(@PathVariable int id) {
		return sd.deleteById(id);
	}
	public String update(@PathVariable int id ,@RequestBody Student s) {
		return sd.update(id,s);
	}

}
