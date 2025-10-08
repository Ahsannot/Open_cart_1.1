package org.example;

public class LargestOfThree {

    int num1, num2, num3;

    // Constructor to initialize the numbers
    public LargestOfThree(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public int findLargestUsingIfElse() {
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }


    public static void main(String[] args) {
        LargestOfThree largest = new LargestOfThree(45, 89, 67);

        System.out.println("Using if-else: Largest number is " + largest.findLargestUsingIfElse());
    }
}
