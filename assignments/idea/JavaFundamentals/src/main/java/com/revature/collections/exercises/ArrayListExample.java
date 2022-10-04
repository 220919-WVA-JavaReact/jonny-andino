package com.revature.collections.exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListExample {

    /*
    Below is a list of exercises to help you get familiar with working with the ArrayList Collection
     */
    public static void main(String[] args) {

        // 1. Write a Java program to create a new array list, add some colors (string) and print out the collection.

        List<String> colors = new ArrayList<String>();

        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Purple");

        System.out.println(colors);


        // 2. Write a Java program to iterate through all elements in an array list

        for (String name: colors) {
            System.out.println(name);
        }

        // 3. Write a Java program to insert an element into the array list at the first position

        colors.add(0, "Fuchsia");
        System.out.println(colors);

        // 4. Write a Java program to retrieve an element (at a specified index) from a given array list

        String purple = colors.get(4);
        System.out.println(purple);

        // 5. Write a Java program to remove the third element from an array list.

        colors.remove(2);
        System.out.println(colors);

        // 6. Write a Java program to search an element in an array list.

        System.out.println(colors.indexOf("Blue"));

        // 7. Write a Java program to sort a given array list.

        colors.sort(Comparator.naturalOrder());
        System.out.println(colors);

    }
}
