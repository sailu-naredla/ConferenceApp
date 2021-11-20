/**
 * 
 */
package com.talks.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.talks.dto.ErrorInfo;



/**
 * @author snaredl
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorInfo> handleIllegalArgException(HttpServletRequest httpServletReq, Exception exception) {
        return getErrorInfoResponseEntity(httpServletReq, exception, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<ErrorInfo> handleResourceAccessException(HttpServletRequest httpServletReq,
            Exception exception) {
        return getErrorInfoResponseEntity(httpServletReq, exception, HttpStatus.BAD_GATEWAY);
    }
	
	 @ExceptionHandler(DataNotFoundException.class)
	    public ResponseEntity<ErrorInfo> handleDataNotFoundException(HttpServletRequest httpServletReq,
	            Exception exception) {
	        return getErrorInfoResponseEntity(httpServletReq, exception, HttpStatus.NOT_FOUND);
	 }
	 
	 private ResponseEntity<ErrorInfo> getErrorInfoResponseEntity(HttpServletRequest httpServletReq, Exception exception,
	            HttpStatus httpStatus) {
	        ErrorInfo error = new ErrorInfo();
	        error.setMessage(exception.getLocalizedMessage());
	        error.setUri(httpServletReq.getRequestURI());
	        return new ResponseEntity<ErrorInfo>(error, httpStatus);
	    }

}
