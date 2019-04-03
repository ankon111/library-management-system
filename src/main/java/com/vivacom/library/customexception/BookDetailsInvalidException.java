package com.vivacom.library.customexception;

/**
 * Created by Ankon on 10/26/2017.
 */
public class BookDetailsInvalidException extends RuntimeException{
    public BookDetailsInvalidException(String message) {
        super(message);
    }
}
