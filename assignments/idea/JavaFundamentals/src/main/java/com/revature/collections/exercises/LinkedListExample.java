package com.revature.collections.exercises;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExample {

    /*
    Below is a list of exercises to help you get familiar with working with the ArrayList Collection
     */
    public static void main(String[] args) {

        // 1. Write a Java program to append the specified element to the end of a linked list. Add several values.

        List<Integer> test = new LinkedList<>();
        test.add(5);
        test.add(7);
        test.add(8);
        test.add(3);
        test.add(6);

        // 2. Write a Java program to iterate through all elements in a linked list.

        for (int i : test){
            System.out.println(i);
        }

        // 3. Write a Java program to iterate a linked list in reverse order

        ListIterator<Integer> it = test.listIterator(test.size());

        while(it.hasPrevious()){
            System.out.println(it.previous());
        }

        // 4.  Write a Java program to insert the specified element at the front of a linked list

        test.add(0, 15);
        System.out.println(test);

        // 5. Write a Java program to insert some elements at the specified position into a linked list.

        test.add(5,24);
        System.out.println(test);

        // 6. Write a Java program to get the first and last occurrence of the specified elements in a linked list.

        System.out.println(test.stream().findFirst());
        System.out.println(test.get(test.size() - 1));

        // 7. Write a Java program to check if a particular element exists in a linked list.

        // 8. Write a Java program to convert a linked list to array list.


    }
}
