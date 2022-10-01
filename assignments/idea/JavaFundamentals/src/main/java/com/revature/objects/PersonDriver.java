package com.revature.objects;

public class PersonDriver {

    /*
    i'm going to use this main method in this PersonDriver class to call
    upon my person class and create person objects
     */
    public static void main(String[] args) {
        // any logic we write here will be thr logic done when we run the program

        int num = 9;

        // declaring an object is slightly different

        Person bryan = new Person("Bryan",71.75,250.5,25);
        System.out.println(bryan.height);
        System.out.println(bryan.name);

        Person kaitlyn = new Person("Kaitlyn", 68.5, 135.6, 25);
        System.out.println(kaitlyn.weight);

        bryan.walk(5);
        kaitlyn.walk(25);

        System.out.println(kaitlyn.talk());

        Person jimmy = new Person();

        System.out.println(jimmy.weight);

        Person kyle = new Person("Kyle");

        //we can reassign the variables given in this case
        jimmy.name = "Jimmy";

        jimmy.walk(6);
        kyle.walk(7);

    }
}
