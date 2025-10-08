package org.example;

public class DigitCounter {

    int number;

    // Constructor to initialize the number
    public DigitCounter(int number) {
        this.number = number;
    }

    // Method to manually count digits
    public int countDigits() {
        int count = 0;
        int temp = number;

        // Handle negative numbers
        if (temp < 0) {
            temp = -temp;
        }

        // Special case: number is 0 → has 1 digit
        if (temp == 0) {
            return 1;
        }

        // Manually divide by 10 to count digits
        while (temp > 0) {
            temp = temp / 10;
            count++;
        }

        return count;
    }

    // Main method to test
    public static void main(String[] args) {
        DigitCounter dc = new DigitCounter(70902);
        System.out.println("Number of digits: " + dc.countDigits());
    }
}
