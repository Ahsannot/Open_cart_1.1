package org.example;

import java.util.Scanner;

public class MaxMinInArray {

    public MaxMinInArray() {

    }

    public void findMaxMin() {
        System.out.println("Enter length of an Array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter" + n + " values in array :");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("You have enter :");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // Output results
        System.out.println("\n✅ Maximum value in the array: " + max);
        System.out.println("✅ Minimum value in the array: " + min);

        sc.close();


    }

    public static void main(String[] args) {
        MaxMinInArray mma = new MaxMinInArray();
        mma.findMaxMin();
    }
}
