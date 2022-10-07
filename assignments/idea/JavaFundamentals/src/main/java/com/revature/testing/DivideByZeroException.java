package com.revature.testing;

public class DivideByZeroException extends RuntimeException{

    //this is a constructor
    public DivideByZeroException (String errorMessage){
        super(errorMessage);
    }
}
