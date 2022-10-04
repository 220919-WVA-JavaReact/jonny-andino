package com.revature.collections.exercises;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    /*
    Below is a list of exercises to help you get familiar with working with the HashMap Collection
     */
    public static void main(String[] args) {

        // 1. Create a HashMap with Integers for the Keys and Strings for the Entries. Insert 5 entries with numbers as
        // the key and colors as the value associated

        Map<Integer, String> test = new HashMap<Integer, String>();
        test.put(5,  "Red");
        test.put(10, "Green");
        test.put(15, "Blue");
        test.put(20, "Purple");
        test.put(25, "Fuchsia");

        // 2. Write a Java program to count the number of key-value (size) mappings in a map.

        System.out.println(test.size());

        // 3. Write a Java program to test if a map contains a mapping for the specified key

        System.out.println(test.containsKey(25));

        // 4. Write a Java program to get the value of a specified key in a map.

        System.out.println(test.get(20));

        // 5. Write a Java program to get a set view of the keys contained in this map.

        // System.out.println(test.entrySet());
        System.out.println(test.keySet());
    }
}
