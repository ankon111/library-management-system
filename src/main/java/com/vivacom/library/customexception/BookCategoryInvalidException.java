package com.vivacom.library.customexception;

/**
 * Created by Ankon on 10/26/2017.
 */
public class BookCategoryInvalidException extends RuntimeException{
    public BookCategoryInvalidException(String message) {
        super(message);
    }
}
