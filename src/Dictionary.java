import java.io.*;
import java.util.Collections;
import java.util.Objects;
import java.util.TreeSet;

public class Dictionary {
    public TreeSet<String> words; // the data structure used to store my dictionary
    public String allowed = "y";
    public Dictionary (String filename) {
        words = new TreeSet<>();
        String path = "/Users/karin/IdeaProjects/Wordle/src/" + filename + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                Collections.addAll(this.words, words);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllWords() {
        for (String word : words) {
            System.out.println(word);
        }
    }

    public void setAllowed(String wrod) {
        allowed = wrod;
    }
    public boolean real(String wourd) { // for making the loops to ensure user is using
        if (allowed.equals("n")) {
            return true;
        }
        return words.contains(wourd);
    }
}
