package org.example;

import java.util.Scanner;

public class PrimeCheck {

    int number;

    // Constructor to initialize the number
    public PrimeCheck(int num) {

        this.number = num;
    }

    // Method to check if the number is prime
    public boolean isPrime() {
        if (number <= 1) {
            return false;  // 0 and 1 are not prime numbers
        }

        // Check from 2 to number-1 manually
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false; // Divisible by i means not prime
            }
        }
        return true; // No divisors found means prime
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to check if it is prime: ");
        int inputNumber = sc.nextInt();

        // Create an object with the input number
        PrimeCheck primeCheck = new PrimeCheck(inputNumber);

        // Check and print result
        if (primeCheck.isPrime()) {
            System.out.println(inputNumber + " is a Prime Number.");
        } else {
            System.out.println(inputNumber + " is NOT a Prime Number.");
        }

        sc.close();
    }
}
