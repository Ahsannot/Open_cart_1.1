package org.example;

public class PalindromeString {

    private String input;

    // Constructor to initialize input string
    public PalindromeString(String input) {
        this.input = input;
    }

    // Method to check palindrome manually ignoring spaces and punctuation
    public boolean isPalindrome() {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
                return false; // Not a palindrome
            }

            left++;
            right--;
        }

        return true; // Palindrome
    }

    // Main method to test the palindrome checker
    public static void main(String[] args) {
        String testStr = "A man, a plan, a canal: Panama";

        PalindromeString palindrome = new PalindromeString(testStr);

        if (palindrome.isPalindrome()) {
            System.out.println("'" + testStr + "' is a Palindrome string.");
        } else {
            System.out.println("'" + testStr + "' is NOT a Palindrome string.");
        }
    }
}
