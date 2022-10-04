package com.revature.collections.exercises;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    /*
    Below is a list of exercises to help you get familiar with working with the HashSet Collection
     */
    public static void main(String[] args) {

        // 1. Write a Java program to append the specified element to the end of a hash set

        Set<Integer> test = new HashSet<Integer>();
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(6); // set can not contain duplicates
        test.add(7);

        System.out.println(test);

        // 2. Write a Java program to iterate through all elements in a hash list.

        for (int i : test){
            System.out.println(i);
        }

        // 3. Write a Java program to get the number of elements in a hash set

        System.out.println(test.size());

        // 4. Write a Java program to test a hash set is empty or not

        System.out.println(test.isEmpty());

        // 5. Write a Java program to convert a hash set to an array.

        Object[] converted = test.toArray();
        for (Object i : converted){
            System.out.println(i);
        }

    }
}
