public class Guess {
    String guess;
    int attempts;
    String word;
    public Guess () {
        guess = "";
        attempts = 0;
    }
    public void setGuess (String guess) {
        this.guess = guess.toUpperCase();

    }
    public String getGuess () {
        return guess;
    }
    public void setWo (String word) {
        this.word = word;
    }
    public void setAttempts (int attempts) {
        this.attempts = attempts;
    }
    public int getAttempts () {
        return attempts;
    }
    public void subtract () {
        attempts --;
    }
    public String test () {
        String it = "";
        for (int i = 0; i < word.length(); i++) {
            if (guess.substring(i, i+1).equals((word.substring(i, i+1)))) {
                it = it + guess.charAt(i);
            } else if (word.contains(guess.substring(i,i+1))) {
                it = it + "*";
            } else {
                it = it + "-";
            }
        }
        return it;
    }
}