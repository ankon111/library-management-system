package com.vivacom.library.customexception;

/**
 * Created by Ankon on 10/26/2017.
 */
public class AuthorInvalidException extends RuntimeException{

    public AuthorInvalidException(String message) {
        super(message);
    }
}
