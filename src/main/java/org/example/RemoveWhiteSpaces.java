package org.example;

public class RemoveWhiteSpaces {

    // Instance variable to hold the input string
    private String input;

    // Constructor to initialize the input string
    public RemoveWhiteSpaces(String input) {
        this.input = input;
    }

    // Method to remove all white spaces from the string
    public String removeSpaces() {
        // Using replaceAll with regex to remove all white spaces
        return input.replaceAll("\\s", "");
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        RemoveWhiteSpaces remover = new RemoveWhiteSpaces("Java  Programming  Language");
        System.out.println("Original String: '" + remover.input + "'");
        System.out.println("String without spaces: '" + remover.removeSpaces() + "'");
    }
}
