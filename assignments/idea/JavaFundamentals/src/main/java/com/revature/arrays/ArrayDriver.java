package com.revature.arrays;

import java.util.Arrays;

public class ArrayDriver {
    public static void main(String[] args) {
        int[] nums = new int[10];

        System.out.println(nums);

        int[] myArray = {1,2,3,4,5};
        System.out.println(Arrays.toString(myArray));

        double balance = 0;
        double[] transactions = {
          1000,
          -119.99,
          40,
          -35.43,
          -150.65
        };

        // how would we find tha balance here
        // i have to find the sum of thr values in the array

        for (int i = 0; i < transactions.length; i++) {
            balance += transactions[i];
        }

        System.out.println("Balance:" + balance);

        for (int i = 0; i < transactions.length; i++) {
            System.out.println(transactions[i]);
        }

        // sort this array
        char[] sizesOfShirts = {'S', 'M', 'L', 'S', 'L', 'X', 'W'}; //<- W for wumbo
        int[] sizesAsNumbers = {2,   3,    4,   2,   4,   5,   6};

        Arrays.sort(sizesAsNumbers);
        System.out.println(Arrays.toString(sizesAsNumbers));
    }
}
