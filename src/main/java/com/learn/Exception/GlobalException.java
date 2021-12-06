package com.learn.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(EmailIdAlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> emailAlreadyExistsException(EmailIdAlreadyExistsException ex,WebRequest request)
	{
		ExceptionResponse response=new ExceptionResponse(new Date(),ex.getMessage() ,request.getDescription(false));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
