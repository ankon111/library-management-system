package com.vivacom.library.enumeratin;

/**
 * Created by Ankon on 10/19/2017.
 */
public enum SearchingCriteria {

    ALL(0),
    NAME(1),
    AUTHOR(2),
    BOOK_CATEGORY(3);

    

    private int status;

    SearchingCriteria(int status){
        this.status = status;
    }

    public int getValue(){
        return status;
    }
}
