package org.example;

import java.util.Scanner;

public class DuplicateElements {

    public DuplicateElements() {
        // Constructor
    }

    public void duplicateArray() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of the array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter values of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Entered values are:");
        for (int value : arr) {
            System.out.println(value);
        }

        // To keep track of printed duplicates
        boolean[] isDuplicate = new boolean[n];

        System.out.println("Duplicated values are:");
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (isDuplicate[i]) continue;

            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    if (!found) found = true;
                    System.out.println(arr[i]);
                    isDuplicate[j] = true; // Mark duplicates
                    break; // Only print once
                }
            }
        }

        if (!found) {
            System.out.println("No duplicates found.");
        }

        sc.close(); // Close scanner
    }

    public static void main(String[] args) {
        DuplicateElements de = new DuplicateElements();
        de.duplicateArray();
    }
}
