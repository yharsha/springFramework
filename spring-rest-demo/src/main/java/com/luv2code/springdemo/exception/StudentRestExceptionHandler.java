package com.luv2code.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//Add an exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception)
		{
			StudentErrorResponse errorResponse = new StudentErrorResponse();
			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			errorResponse.setMessage(exception.getMessage());
			errorResponse.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		}
		
		////Add an exception handler  for anytype excception
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception ex)
		{
			StudentErrorResponse errorResponse = new StudentErrorResponse();
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			errorResponse.setMessage(ex.getMessage());
			errorResponse.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		}

}
