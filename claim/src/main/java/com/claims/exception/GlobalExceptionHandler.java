package com.claims.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.claims.model.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler({ InvalidSessionException.class })
	public ResponseEntity<ErrorDetails> serverExceptionHandler(Exception exc, WebRequest request) {

		ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(erd, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * @ExceptionHandler(PolicyNotSubscribedException.class) public
	 * ResponseEntity<ErrorDetails>
	 * notSubscribedExceptionHandler(PolicyNotSubscribedException exc, WebRequest
	 * request) {
	 * 
	 * ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(),
	 * request.getDescription(false)); return new ResponseEntity<ErrorDetails>(erd,
	 * HttpStatus.NOT_FOUND); }
	 */

	@ExceptionHandler({ PolicyNotFoundException.class, MemberNotFoundException.class, ClaimNotFoundException.class })
	public ResponseEntity<ErrorDetails> notFoundErrorHandler(PolicyNotFoundException exc, WebRequest request) {

		ErrorDetails erd = new ErrorDetails(new Date(), exc.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(erd, HttpStatus.NOT_FOUND);
	}

}