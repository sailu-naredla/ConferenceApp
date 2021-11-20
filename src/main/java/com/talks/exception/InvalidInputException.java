/**
 * 
 */
package com.talks.exception;

/**
 * @author snaredl
 *
 */
public class InvalidInputException extends RuntimeException {

    private static final long serialVersionUID = -157417501220245966L;

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public InvalidInputException(Throwable throwable) {
        super(throwable);
    }
}
