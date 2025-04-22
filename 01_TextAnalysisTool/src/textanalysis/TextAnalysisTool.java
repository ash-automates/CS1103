package textanalysis;

import java.util.Scanner;

public class TextAnalysisTool {
    public static void main(String[] args) {
        System.out.println("Please enter the text to analyze (Press ENTER on an empty line to finish):");
        StringBuilder builder = new StringBuilder();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                }
                builder.append(input).append(System.lineSeparator());
            }
            if (builder.toString().trim().isEmpty()) {
                System.out.println("No text was entered. Please restart and enter valid text.");
                return;
            }
            int choice = -1;
            do {
                TextAnalysisTool.showMenu();
                System.out.println("Please select an option:");
                String line = scanner.nextLine();
                try {
                    choice = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number, please try again.");
                    continue;
                }
                TextAnalysisTool.handleChoice(choice, builder.toString(), scanner);
            } while (choice != 0);
        }

    }

    public static void showMenu() {
        String menu = """
                Please choose an analysis option:
                    1. Count characters
                    2. Count words
                    3. Count unique words
                    4. Character frequency
                    5. Word frequency
                    6. Most common character
                    0. Exit
                """;
        System.out.println(menu);
    }

    public static void handleChoice(int option, String text, Scanner scanner) {
        switch (option) {
            case 1:
                // Count characters
                int charCount = TextAnalyzer.countCharacters(text);
                System.out.println("Total number of characters is " + charCount + ".");
                break;
            case 2:
                // Count words
                int wordCount = TextAnalyzer.countWords(text);
                System.out.println("Total number of words is " + wordCount + ".");
                break;
            case 3:
                // Count unique words
                int uniqueCount = TextAnalyzer.countUniqueWords(text);
                System.out.println("Total number of unique words is " + uniqueCount + ".");
                break;
            case 4:
                // Ask for a character, count its frequency
                System.out.println("Insert the character you wish to count and press \"Enter\":");
                String input = scanner.nextLine();
                if (input.length() != 1) {
                    System.out.println("Please enter exactly one character.");
                    return;
                }
                char picked = input.charAt(0);
                int charFrequency = TextAnalyzer.characterFrequency(text, picked);
                System.out.println("the character " + picked + " occurs " + charFrequency + " time(s).");
                break;
            case 5:
                // Ask for a word, count its frequency
                System.out.println("Insert the word you wish to count and press \"Enter\":");
                String word = scanner.nextLine();
                int wordFrequency = TextAnalyzer.wordFrequency(text, word);
                System.out.println("the word " + word + " occurs " + wordFrequency + " time(s).");
                break;
            case 6:
                // Show most common character
                char frequentChar = TextAnalyzer.mostCommonCharacter(text);
                System.out.println("The most common character is " + frequentChar + "!");
                break;
            case 0:
                return;
            default:
                // Invalid option
                System.out.println("You can pick one of the available options, please try again!");
                break;
        }
    }
}
