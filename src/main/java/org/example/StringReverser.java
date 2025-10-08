package org.example;

public class StringReverser {

    String input;

    // Constructor
    public StringReverser(String input) {
        this.input = input;
    }

    // Method 1: Using StringBuilder (Built-in method)
    public String reverseWithStringBuilder() {
        return new StringBuilder(input).reverse().toString();
    }

    // Method 2: Using a for loop (manual character appending)
    public String reverseWithLoop() {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);  // Using StringBuilder would be more efficient
        }
        return reversed;
    }

    // Method 3: Using recursion
    public String reverseWithRecursion() {
        return reverseRecursively(input);
    }

    // Helper method for recursion
    private String reverseRecursively(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

    // Display method to show all reverse methods
    public void display() {
        System.out.println("Original String: " + input);
        System.out.println("Reversed (StringBuilder): " + reverseWithStringBuilder());
        System.out.println("Reversed (Loop): " + reverseWithLoop());
        System.out.println("Reversed (Recursion): " + reverseWithRecursion());
    }

    // Main method to test
    public static void main(String[] args) {
        StringReverser reverser = new StringReverser("hello");

        // Call display method
        reverser.display();
    }
}
