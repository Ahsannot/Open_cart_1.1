package org.example;

import java.util.Scanner;

public class PalindromeNumber {

    int number;

    // Constructor to initialize the number
    public PalindromeNumber(int number){
        this.number = number;
    }

    // Method to check if the instance number is palindrome
    public boolean isPalindrome() {
        int originalNumber = number;  // Store the original number
        int reversedNumber = 0;
        int temp = number;  // Use a temp variable to avoid changing number

        // Reverse the number
        while (temp != 0) {
            int digit = temp % 10;                // Extract last digit
            reversedNumber = reversedNumber * 10 + digit; // Append digit
            temp /= 10;                          // Remove last digit
        }

        // Check if original and reversed numbers are equal
        return originalNumber == reversedNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // Create an instance of PalindromeNumber with input
        PalindromeNumber palindrome = new PalindromeNumber(num);

        // Call instance method isPalindrome()
        if (palindrome.isPalindrome()) {
            System.out.println(num + " is a Palindrome number.");
        } else {
            System.out.println(num + " is NOT a Palindrome number.");
        }

        scanner.close();
    }
}
