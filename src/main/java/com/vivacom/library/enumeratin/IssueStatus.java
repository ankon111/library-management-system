package com.vivacom.library.enumeratin;

/**
 * Created by Ankon on 10/19/2017.
 */
public enum IssueStatus {

    BORROWED('B'),
    RETURNED('R');

    private char status;

    IssueStatus(char status){
        this.status = status;
    }

    public char getValue(){
        return status;
    }

}
