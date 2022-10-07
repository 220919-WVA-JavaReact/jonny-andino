package com.revature.testing;

public class Calculator {
    //add
    public int addNumbers(int a, int b){
        return a + b;
    }

    //subtract
    public int subtractNumbers(int a, int b) {
        return a - b;
    }

    //multiplication
    public double multNumbers(double a, double b){
        return  a * b;
    }

    //division
    public double divideNumbers(double a, double b) throws DivideByZeroException{
        if (b == 0) {
            throw new DivideByZeroException("You can not divide by Zero");
        } else {
            return a / b;
        }
    }

    // division with ints
    public int divideNumbers(int a, int b) {
        return a / b;
    }
}
