package com.vivacom.library.customexception;

/**
 * Created by Ankon on 10/26/2017.
 */
public class BookIssuedException extends RuntimeException{
    public BookIssuedException(String message) {
        super(message);
    }
}
