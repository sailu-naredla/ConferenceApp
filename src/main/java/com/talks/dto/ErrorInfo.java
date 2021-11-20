/**
 * 
 */
package com.talks.dto;

import java.io.Serializable;

/**
 * This class maps the generic error response with error message and uri
 * 
 * @author snaredl
 *
 */
public class ErrorInfo implements Serializable {

    private static final long serialVersionUID = -5408627893841642295L;

    private String message;
    private String uri;

    public ErrorInfo() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
