package com.revature.calculator;

import javax.script.ScriptException;

public class CalcRunner {

    public static void main(String[] args) throws ScriptException {
        CLI program = new CLI();

        program.start();

        System.out.println("Would you like to go again? y/n");
        program.input.nextLine(); // input doesn't get read correctly unless i do this
        String response = program.input.nextLine();

        if (response.equals("y")){
            program.start();
        } 
    }
}
