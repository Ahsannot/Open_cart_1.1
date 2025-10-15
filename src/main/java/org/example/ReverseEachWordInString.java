package org.example;

public class ReverseEachWordInString {

    // Method to reverse a single word using charAt and string concatenation
    public String reverseWord(String word) {
        String reverseWord = "";

        // Loop through the word in reverse order
        for (int i = word.length() - 1; i >= 0; i--) {
            reverseWord += word.charAt(i);  // Append each character from end to start
        }

        return reverseWord;  // Return the reversed word
    }

    // Method to reverse each word in the given sentence
    public String reverseEachWord(String sentence) {
        // Split the sentence into words using space as a delimiter
        String[] words = sentence.split(" ");
        String reverseString = "";

        // Loop through each word in the array
        for (String w : words) {
            // Reverse the current word using the reverseWord() method
            String reversedWord = reverseWord(w);

            // Append the reversed word and a space to the final result
            reverseString += reversedWord + " ";
        }

        // Return the final string after trimming any trailing space
        return reverseString.trim();
    }

    public static void main(String[] args) {
        // Create an instance of the class to access non-static methods
        ReverseEachWordInString reverser = new ReverseEachWordInString();

        // Define the input string
        String input = "Welcome To Java";

        // Call the method to reverse each word in the input string
        String output = reverser.reverseEachWord(input);

        // Print the final result
        System.out.println(output);  // Output: emocleW oT avaJ
    }
}
