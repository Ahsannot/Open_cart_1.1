package org.example;

import java.util.Arrays;
import java.util.Scanner;

// Class to handle array sorting
class ArraySorter {
    public int[] array;

    // Method to accept input
    public void readArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        array = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
    }

    // Method to sort array
    public void sortArray() {
        Arrays.sort(array);
    }

    // Method to display array
    public void displayArray() {
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println(); // for clean output
    }

    public static void main(String[] args) {
        ArraySorter sorter = new ArraySorter();

        sorter.readArray();     // Input
        sorter.sortArray();     // Process
        sorter.displayArray();  // Output
    }

}


