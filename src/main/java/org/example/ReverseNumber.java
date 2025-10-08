package org.example;

public class ReverseNumber {

    int number;

    // Constructor to initialize number
    public ReverseNumber(int number) {
        this.number = number;
    }

    // Method 1: Reverse using a while loop (Arithmetic method)
    public int reverseUsingLoop() {
        int num = number;
        int rev = 0;
        while (num != 0) {
            int digit = num % 10;   // Extract last digit
            rev = rev * 10 + digit; // Append digit
            num /= 10;  // Remove last digit
        }
        return rev;
    }

    // Method 2: Reverse using StringBuilder
    public int reverseUsingStringBuilder() {
        String str = Integer.toString(number); // Convert the integer number to a String
        // Use StringBuilder to reverse the string representation of the number
        String reversed = new StringBuilder(str).reverse().toString();
        // Convert the reversed string back to an integer and return
        return Integer.parseInt(reversed);
    }

    // Method 3: Reverse using recursion
    public int reverseUsingRecursion() {
        return reverseRec(number, 0);
    }

    // Helper for recursion
    private int reverseRec(int num, int rev) {
        if (num == 0) return rev;
        return reverseRec(num / 10, rev * 10 + num % 10);
    }

    // Main method to test
    public static void main(String[] args) {
        ReverseNumber obj = new ReverseNumber(12345);

        System.out.println("Original Number: " + obj.number);
        System.out.println("Reversed (Loop): " + obj.reverseUsingLoop());
        System.out.println("Reversed (StringBuilder): " + obj.reverseUsingStringBuilder());
        System.out.println("Reversed (Recursion): " + obj.reverseUsingRecursion());
    }
}
