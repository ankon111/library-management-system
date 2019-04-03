package com.vivacom.library.model.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by Ankon on 10/21/2017.
 */
public class SuccessResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
