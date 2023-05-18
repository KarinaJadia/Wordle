import java.io.*;
import java.util.Collections;
import java.util.TreeSet;

public class Dictionary {
    public TreeSet<String> words; // the data structure used to store my dictionary
    public Dictionary (String filename) {
        words = new TreeSet<>();
        String path = "/Users/karin/IdeaProjects/Wordle/src/" + filename + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                Collections.addAll(this.words, words);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean containsWord(String word) {
        return words.contains(word);
    }
    public void printAllWords() {
        for (String word : words) {
            System.out.println(word);
        }
    }
}
