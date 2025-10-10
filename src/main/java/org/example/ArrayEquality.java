package org.example;

import java.util.Scanner;

public class ArrayEquality {
    public ArrayEquality(){

    }
    public void equalityOfArray(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of an Array 1: ");
        int n1 = sc.nextInt();

        System.out.println("Enter length of an Array 2: ");
        int n2 = sc.nextInt();

        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        System.out.println("Enter" + n1 + " values in array 1 :");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("You have enter :");
        for (int i = 0; i < n1; i++) {
            System.out.println(arr1[i]);
        }

        System.out.println("Enter" + n2 + " values in array 2 :");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.print("You have enter :");
        for (int i = 0; i < n2; i++) {
            System.out.println(arr1[2]);
        }
        if (arr1.length != arr2.length) {
            System.out.println("Arrays are not equal (different lengths)");
            return;
        }

        boolean status = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                status = false;
                break; // Exit early if mismatch found
            }
        }
        if (status) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }
    }

    public static void main(String[] args) {
        ArrayEquality ae = new ArrayEquality();
        ae.equalityOfArray();
    }
}
