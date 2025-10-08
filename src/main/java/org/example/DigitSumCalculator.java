package org.example;

import java.util.Scanner;

public class DigitSumCalculator {

    int number;

    // Constructor to initialize the number
    public DigitSumCalculator(int number) {
        this.number = number;
    }

    // Method to manually calculate the sum of digits
    public int calculateSumOfDigits() {
        int sum = 0;
        int temp = number;

        // Convert to positive if number is negative
        if (temp < 0) {
            temp = -temp;
        }

        while (temp > 0) {
            int digit = temp % 10;   // Extract last digit
            sum = sum + digit;       // Add digit to sum
            temp = temp / 10;        // Remove last digit
        }

        return sum;
    }

    // Main method to accept input and display result
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int userInput = scanner.nextInt();

        DigitSumCalculator calculator = new DigitSumCalculator(userInput);
        int sum = calculator.calculateSumOfDigits();

        System.out.println("Sum of digits: " + sum);

        scanner.close();
    }
}
