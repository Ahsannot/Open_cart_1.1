package org.example;

import java.util.Scanner;

public class SelectionSort {

    private int[] arr;

    // Constructor: initializes array from user input
    public SelectionSort() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    // Method to perform selection sort
    public void sort() {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the smallest element in the rest of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the current element
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // Method to display the array
    public void display() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method: creates object, sorts, and displays result
    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort(); // Constructor handles input

        System.out.println("\nOriginal array:");
        sorter.display();

        sorter.sort();

        System.out.println("Sorted array:");
        sorter.display();
    }
}
