package com.revature.objects;

// the first uncommented line of the java files should be the package name
// packages provide useful namespaces for us to declare similar classes with the correct name

public class Person {

    /*
    this is a multiline comment
    we talked about classes yesterday, and said classes are blueprints for objects
    but what does this mean?

    we can create classes as blueprints with all the necessary info we expect EVERY
    object from that class to have

    first thing, i'll create fields which are similar to properties of the object we create these
    just like regular variables from yesterday only we don't necessarily have to give them a value

    fields we might want for a person class:
    name,   -> String
    height, -> double
    weight, -> double
    age.    -> int

    we'll declare these props at the class level outside of amy method
     */

    String name;
    double height;
    double weight;
    int age;

    /*
    now every time i create a person object they should have these properties associated with them
    and depending on how the variable is accessible i should be able to call the value by saying
    something like personObject.field

    we're going to create a constructor for this class
    constructors are special methods with the same name as the class itself and provides a simple way
    to set up the state of an instantiated object

     */
    public Person(String name, double height, double weight, int age){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    /*
    before, we created an all args constructor, but what if i wanted a default person
    or only wanted to see some of the values
     */

    // no args constructor
    public Person(){
        this.name = "James";
        this.height = 67;
        this.weight = 140.0;
        this.age = 35;
    }

    //1-arg constructor

    public Person(String name){
        this.name = name;
        this.height = 67;
        this.weight = 140.0;
        this.age = 35;
    }

    /*
    let's add in some methods
    methods are reuseable chunks of code that generally represent what an object can do
     */

    public void walk(int dist){

        System.out.println(this.name + " walked a distance of: " + dist + " feet");
    }

    //we'll create a method for talking

    public String talk(){

        return "Hi, my name is: " + this.name;
    }
}
