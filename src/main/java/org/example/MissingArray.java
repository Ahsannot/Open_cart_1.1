package org.example;

import java.util.Scanner;

public class MissingArray {

    int number ;

    public MissingArray (int number){
        this.number = number;
    }

    public  void missingArray(){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[number-1];

        System.out.println("Enter " + (number - 1) + " numbers (from 1 to " + number + "):");
        for (int i = 0; i < number-1 ; i++) {
            System.out.print("Enter number in array : ");
            arr[i] = sc.nextInt();
        }
        int expectedSum = number * (number + 1) / 2;
        int actualSum = 0 ;
        for (int num : arr){
                actualSum += num ;
        }

        int missing = expectedSum - actualSum;
        System.out.println("Missing number is: " + missing);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N :");
        int n = sc.nextInt();
        MissingArray ma = new MissingArray(n);
        ma.missingArray();
    }
}
