package com.employee.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exceptions.AgeException;

@RestControllerAdvice
public class GlobalExcetion {
	@ExceptionHandler(AgeException.class)
	public ResponseEntity<Object> ageExp(AgeException e) {
		return new ResponseEntity<>("Not Found", HttpStatus.BAD_REQUEST);

	}

}
