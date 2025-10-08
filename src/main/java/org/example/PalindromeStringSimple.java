
package org.example;

public class PalindromeStringSimple {

    private String input;

    // Constructor to initialize the input string
    public PalindromeStringSimple(String input) {
        this.input = input;
    }

    // Simple manual palindrome check without ignoring spaces or punctuation
    public boolean isPalindrome() {
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false; // Characters don't match, not palindrome
            }
        }

        return true; // All matched, palindrome
    }

    // Main method to test the class
    public static void main(String[] args) {
        String testStr = "madam";

        PalindromeStringSimple palindrome = new PalindromeStringSimple(testStr);

        if (palindrome.isPalindrome()) {
            System.out.println("'" + testStr + "' is a Palindrome string.");
        } else {
            System.out.println("'" + testStr + "' is NOT a Palindrome string.");
        }
    }
}

