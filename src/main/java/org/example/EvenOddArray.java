package org.example;

import java.util.Scanner;

public class EvenOddArray {

    public EvenOddArray(){

    }

    public  void findEvenOdd(){

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

        for (int num : arr){
            if (num % 2 == 0){
                System.out.println("Even number is :" + num);
            }
        }

        for (int num : arr){
            if (num % 2 != 0){
                System.out.println("Odd number is :" + num);
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        EvenOddArray eoa = new EvenOddArray();
        eoa.findEvenOdd();
    }
}
