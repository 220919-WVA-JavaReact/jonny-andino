package com.revature.strings;

public class StringDriver {

    public static void main(String[] args) {
        /*
        we saw yesterday one of thr various methods associated with strings
        string.length()
        today we'll talk a bit more about strings and about how they're stored
        equality, and some methods associated

         */

        String text = "This is a string";

        // we mentioned that strings are objects but when we created our person object earlier
        // we had to do some fancy funky stuff

        // they can be also created like this

        String text2 = new String("This is also a string");

        // let's start adding strings together and see what happens

        String helloWorld = "Hello";

        // let's add onto this original string

        helloWorld += " world";

        System.out.println(helloWorld);

        // java is pass by value not pass by reference

        // helloWorld + "I'm a person"

        addOn(helloWorld);
        System.out.println(helloWorld);

        // if i wanted the value to be updated i would have to store it in the variable itself

        helloWorld = addOn(helloWorld);
        System.out.println(helloWorld);

        String s1 = "Apple";
        String s2 = "Mango";
        String s3 = "Apple";

        // if i want to test equality of these, i'll use my == operator from yesterday

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        // now what happens if i create a string object with the new keyword and test the equality?

        String s4 = new String("Mango"); // this gets stores in the outer Heap and not the string pool.
        System.out.println(s2 == s4); // false

        // when working with objects we see that the == operator actually checks the objects to see if they're the same
        // object in memory, it doesn't check the value, it rather checks the memory address of the data

        // so how do we check for equality of values rather than memory addresses?
        // what we need to call instead of the .equals() method from the Object class
        // which all classes inherit from. it essentially allows us the ability to
        // check the equality of different objects, based on value. (provided that we override .equals())

        System.out.println(s2.equals(s4));

        // this idea of using .equals() for objects is very important, and we'll discuss this later when looking
        // at inheritance and polymorphism

        //      ==         <- memory address comparison
        // Object.equals() <- value comparison


        // let's say i wanted to find a string's length

        String newString = "This is a string";

        System.out.println(newString.length());

        System.out.println(isStringLenEven(newString));

        // what happens if we wanted to repeat a string so many times

        System.out.println(newString.repeat(2));

        // call textrepeat method

        System.out.println(repeatSpace(newString, 5));

    }

    public static String addOn(String text){
        return text + " adding onto the end";
    }

    // let's make a quick method to check and see if the length if a string is even

    public static boolean isStringLenEven(String text) {
        // steps here are to find the length of the string
        // then we check if it is even

        // i'm going to store the length of the string in a variable

        int len = text.length();

        // now how to check if a number is even
        // there's a couple ways to do this but the easiest is the modulus operator %

        return (len % 2 == 0);
    }

    // let's create a quick method for repeating strings with a space in the middle

    public static String repeatSpace(String text, int count){
        //can't just return the string + string.repeat(count)
        // the space makes things more complicated.
        // could use a for loop or use repeat

        // for loop implementation
        String newText = "";
        for (int i = 0; i < count; i++) {
            newText += text;
            newText += " ";
        }

        // this isn't exactly right since it has a space at the end but we'll see how it works
        return newText;
    }
}
