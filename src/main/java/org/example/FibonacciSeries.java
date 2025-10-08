package org.example;

import java.util.Scanner;

public class FibonacciSeries {

    int terms;

    // Constructor to initialize the number of terms
    public FibonacciSeries(int terms) {
        this.terms = terms;
    }

    // Method to generate and print Fibonacci series
    public void generateSeries() {
        int a = 0;
        int b = 1;

        System.out.print("Fibonacci Series up to " + terms + " terms: ");

        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " "); // 0,1,1,2,3

            int c = a + b; // 0+1=1, 1+1=2, 1+2=3, 2+3=5
            a = b; // 1,1,2,3
            b = c; // 1,2,3,5
        }

        System.out.println(); // New line after printing series
    }

    // Main method to test the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        FibonacciSeries fib = new FibonacciSeries(n);
        fib.generateSeries();

        scanner.close();
    }
}
