package com.vivacom.library.customexception;

/**
 * Created by Ankon on 10/26/2017.
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
