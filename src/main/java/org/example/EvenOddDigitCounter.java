package org.example;

public class EvenOddDigitCounter {

    int number;

    // Constructor to initialize number
    public EvenOddDigitCounter(int number) {
        this.number = number;
    }

    // Method to manually count even and odd digits
    public void countEvenOddDigits() {
        int evenCount = 0;
        int oddCount = 0;

        int temp = number;

        // If number is negative, make it positive
        if (temp < 0) {
            temp = -temp;
        }

        // Special case: if number is 0, it is considered even
        if (temp == 0) {
            evenCount = 1;
        }

        // Loop through each digit
        while (temp > 0) {
            int digit = temp % 10; // Get last digit

            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            temp = temp / 10; // Remove last digit
        }

        // Display the result
        System.out.println("Even digits: " + evenCount);
        System.out.println("Odd digits: " + oddCount);
    }

    // Main method to test
    public static void main(String[] args) {
        EvenOddDigitCounter counter = new EvenOddDigitCounter(52019);
        counter.countEvenOddDigits();
    }
}
