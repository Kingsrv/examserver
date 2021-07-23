package com.exam.helper;

public class UserFoundException extends Exception{

    public UserFoundException(){
        super("user with this Username is already present in the database !! Please try with a new name.");
    }

    public UserFoundException(String msg){
        super(msg);
    }
}
