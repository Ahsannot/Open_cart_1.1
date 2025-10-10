package org.example;

import java.util.Scanner;
public class SumArray {
    public SumArray(){
    }
    public void calculateSum(){
        System.out.println("Enter number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " number to array");
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("You have entered :");
        for (int i = 0 ; i < n ; i++){
            System.out.println(arr[i]);
        }

        int sum = 0 ;
        for(int ar : arr ){
            sum += ar ;
        }
        System.out.println("Sum of elements in the array: " + sum);

        // Close the Scanner to free up resources
        sc.close();
    }
    public static void main(String[] args) {
        SumArray sa = new SumArray();
        sa.calculateSum();
    }
}
