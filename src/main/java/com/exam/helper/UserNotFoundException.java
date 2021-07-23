package com.exam.helper;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("user with this Username is not found in the database !! Please try with a different name.");
    }

    public UserNotFoundException(String msg){
        super(msg);
    }
}
