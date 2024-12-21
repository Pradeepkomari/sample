package com.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@PostMapping("/post")
	public String post(@RequestBody Student s) {
		return ss.post(s);
	}
	
	
	@PostMapping("/postList")
	public String postList(@RequestBody List<Student> s) {
		return ss.postList(s);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll(){
		return ss.getAll();
	}
	
	@GetMapping("/getid/{id}")
	public Student getId(@PathVariable Integer id) {
		return ss.getId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return ss.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable int id ,@RequestBody Student s) {
		return ss.update(id, s);
	}
	
	
	

}
