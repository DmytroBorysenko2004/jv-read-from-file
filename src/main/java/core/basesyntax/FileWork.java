package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public static void main(String[] args) {
        String filePath = "file1.txt";
        String[] result = readFromFile(filePath);
        for (String word : result) {
            System.out.println(word);
        }
    }

    public static String[] readFromFile(String filePath) {
        ArrayList<String> filteredWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z\\s]", " ");
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.startsWith("w")) {
                        filteredWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the file", e);
        }

        if (filteredWords.isEmpty()) {
            return new String[0];
        }

        Collections.sort(filteredWords);
        return filteredWords.toArray(new String[0]);
    }
}
