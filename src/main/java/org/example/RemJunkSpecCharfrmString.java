package org.example;


public class RemJunkSpecCharfrmString {
    // Method to remove special characters (keep letters, digits, spaces)
    public String cleanString(String input) {
        if (input == null) {
            return "";
        }
        return input.replaceAll("[^a-zA-Z0-9 ]", "");
    }

    public static void main(String[] args) {
        String dirtyText = "Hello@# World!! 123***";

        // Create an instance of the class
        RemJunkSpecCharfrmString cleaner = new RemJunkSpecCharfrmString();

        // Clean the string
        String cleanedText = cleaner.cleanString(dirtyText);

        // Print results
        System.out.println("Original: " + dirtyText);
        System.out.println("Cleaned: " + cleanedText);
    }
}
