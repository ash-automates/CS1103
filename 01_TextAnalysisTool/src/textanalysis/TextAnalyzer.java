package textanalysis;

import java.util.HashSet;
import java.util.Set;

public class TextAnalyzer {
    public static int countCharacters(String text) {
        return text.length();
    }

    public static int countWords(String text) {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    public static char mostCommonCharacter(String text) {
        int[] letterFrequencies = new int[26];
        for (int i = 0; i < letterFrequencies.length; i++) {
            letterFrequencies[i] = characterFrequency(text, (char) ('a' + i));
        }
        int idxOfMax = 0;
        for (int i = 1; i < letterFrequencies.length; i++) {
            if (letterFrequencies[idxOfMax] <= letterFrequencies[i]) {
                idxOfMax = i;
            }
        }
        if (letterFrequencies[idxOfMax] == 0) {
            throw new IllegalArgumentException("No alphabetic characters found.");
        }
        return (char) ('a' + idxOfMax);
    }

    public static int characterFrequency(String text, char c) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char possibleMatch = Character.toLowerCase(text.charAt(i));
            if (possibleMatch == c) {
                count += 1;
            }
        }
        return count;
    }

    public static int wordFrequency(String text, String word) {
        if (text == null || word == null) {
            throw new IllegalArgumentException("Text and word must not be null.");
        }
        int count = 0;
        for (String possibleMatch : text.trim().split("\\s+")) {
            if (possibleMatch.toLowerCase().equals(word.toLowerCase())) {
                count += 1;
            }
        }
        return count;
    }

    public static int countUniqueWords(String text) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : text.trim().split("\\s+")) {
            uniqueWords.add(word.toLowerCase());
        }
        return uniqueWords.size();
    }
}
