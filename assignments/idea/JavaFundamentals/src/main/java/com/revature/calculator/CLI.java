package com.revature.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class CLI {

    Scanner input;
    float first;
    char operator;
    float second;

    public CLI(){
        this.input = new Scanner(System.in);
        this.first = 0;
        this.operator = '+';
        this.second = 0;
    }

    public void start() throws ScriptException {
        this.getFirst();
        this.getOperator();
        this.getSecond();
        this.evaluate();
    }

    public void getFirst(){
        System.out.println("Welcome! Please enter a number");
        this.first = input.nextFloat();
    }

    public void getOperator(){
        System.out.println("Please enter an operator");
        this.operator = input.next().charAt(0);
    }

    public void getSecond(){
        System.out.println("Please enter a second number");
        this.second = input.nextFloat();
    }

    public void evaluate() throws ScriptException {

        // dark magic i found from the internet
        // this is importing the JAVASCRIPT ENGINE????? absolutely bonkers. i had to try it
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine     = mgr.getEngineByName("JavaScript");
        String expression       = "" + this.first + this.operator + this.second; // anything can be a string if you concat to a string!
        String answer           = "" + engine.eval(expression);

        System.out.println (
            this.first + " "
            + this.operator + " "
            + this.second + " = "
            + answer
        );
    }
}
