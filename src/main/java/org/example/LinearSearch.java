package org.example;

import java.util.Scanner;

public class LinearSearch {

    public void searchElement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the number to find: ");
        int number = sc.nextInt();

        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                System.out.println(number + " is found at position " + i);
                flag = true;
//                break;
            }
        }

        if (!flag) {
            System.out.println(number + " is not found in the array.");
        }

        sc.close();
    }

    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        ls.searchElement();
    }
}
