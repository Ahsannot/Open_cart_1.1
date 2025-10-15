package org.example;

public class WordCounter {
    private String text;

    public WordCounter(String text) {
        this.text = text;
    }

    public int countWords() {
        int count = 0;
        boolean wordFound = false;  // Flag to track if we're currently inside a word

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If the character is not a space, tab, or newline — it's part of a word
            if (ch != ' ' && ch != '\t' && ch != '\n') {
                // If this is the first non-space character after a space, it's a new word
                if (!wordFound) {
                    wordFound = true; // Mark that we're now inside a word
                    count++;          // Increment the word count
                }
            } else {
                wordFound = false;
            }
        }

        // Return the final word count
        return count;
    }

    public static void main(String[] args) {
        // Create an instance of WordCounter with a sample string
        WordCounter wc = new WordCounter("Hello there! How are you?");

        // Output the result of the word count
        System.out.println("Number of words: " + wc.countWords());
    }
}
