package com.vivacom.library.model.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by Ankon on 10/20/2017.
 */
public class ExceptionResponse {

    private int errorCode;
    private String errorMessage;
    private List<String> errors;

    public ExceptionResponse() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}