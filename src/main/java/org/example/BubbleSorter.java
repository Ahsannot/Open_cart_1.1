package org.example;

import java.util.Scanner;

public class BubbleSorter {

    public int[] arr;            // Public array
    public int n;                // Public size of array
    public Scanner scanner;      // Public Scanner object

    // Method to take input from user
    public void inputArray() {
        scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        n = scanner.nextInt();

        arr = new int[n];
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    // Method to perform bubble sort
    public void sortArray() {
        // Bubble Sort Algorithm
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            // The n - 1 - i condition ensures that with each outer loop pass, we don't re-check the last i sorted elements.
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: if no two elements were swapped, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Method to display the array
    public void displayArray(String message) {
        System.out.println(message);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        BubbleSorter sorter = new BubbleSorter();

        sorter.inputArray();
        sorter.displayArray("Original array:");
        sorter.sortArray();
        sorter.displayArray("Sorted array:");
    }
}
