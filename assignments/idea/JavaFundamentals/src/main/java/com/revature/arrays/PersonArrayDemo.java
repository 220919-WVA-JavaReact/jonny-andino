package com.revature.arrays;

import com.revature.objects.Person;

import java.util.ArrayList;

public class PersonArrayDemo {
    public static void main(String[] args) {

        // i want to try an array of objects

        Person[] pplArray = {
            new Person("Rickey"),
            new Person("Cory"),
            new Person("Richard"),
            new Person("Jonny")
        };

        //for every person, run the walk method
        for (Person p: pplArray) {
            p.walk(10);
        }

        // i can't add to this list since it's a fixed size after being initialized. so i'd have to use an arraylist?

        // pplArray[4] = new Person("Bryan"); <- array index out of bounds

        // this is what i want most of the time i think

        ArrayList<Person> pplList = new ArrayList<Person>();

        pplList.add(new Person("Bryan"));
        pplList.add(new Person("Kevin"));

        for (Person p: pplList) {
            p.walk(15);
        }

        pplList.remove(1); //<- goodbye kevin

        for (Person p: pplList) {
            p.walk(20);
        }
    }
}
