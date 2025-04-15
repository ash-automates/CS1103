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
        }
        System.out.println(builder);
    }
}
