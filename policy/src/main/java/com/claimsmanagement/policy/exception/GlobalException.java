package com.claimsmanagement.policy.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.claimsmanagement.policy.model.ErrorDetails;

@ControllerAdvice
public class GlobalException extends Exception {
	
	@ExceptionHandler(PolicyRunTimeExc.class)
	public ResponseEntity<ErrorDetails> handle_policyexc(PolicyRunTimeExc exc, WebRequest request){
		
		ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(),request.getDescription(false));
		return  new ResponseEntity<ErrorDetails>(erd,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handle_exc(Exception exc, WebRequest request){
	
	ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(),request.getDescription(false));
	return  new ResponseEntity<ErrorDetails>(erd,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PolicyNotSubscribedException.class)
	public ResponseEntity<ErrorDetails> handle_exc( PolicyNotSubscribedException exc, WebRequest request){
	
	ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(),request.getDescription(false));
	return  new ResponseEntity<ErrorDetails>(erd,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PolicyNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle_exc( PolicyNotFoundException exc, WebRequest request){
	
	ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(),request.getDescription(false));
	return  new ResponseEntity<ErrorDetails>(erd,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle_exc( MemberNotFoundException exc, WebRequest request){
	
	ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(),request.getDescription(false));
	return  new ResponseEntity<ErrorDetails>(erd,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BenefitNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle_exc( BenefitNotFoundException exc, WebRequest request){
	
	ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(),request.getDescription(false));
	return  new ResponseEntity<ErrorDetails>(erd,HttpStatus.NOT_FOUND);
	}
	
	
}