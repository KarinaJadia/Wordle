import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // creates a scanner object
        Word word = new Word(); // creates wordle guess word object
        Guess guess = new Guess(); // creates user guess
        Dictionary dictionary = new Dictionary("words"); // creates the dictionary
        dictionary.initialize();
        dictionary.printAllWords();

        System.out.println("Please input the word to guess:");
        word.setWord(input.next().toUpperCase()); // takes user input and sets word
        guess.setWo(word.getWord()); // same user input for the guess class, kind of redundant but whatevs
        System.out.println("Please input how many guesses the player will get:");
        guess.setAttempts(Integer.parseInt(input.next())); // converts user input to int and takes it

        System.out.println("\n\n\n\n\n\n\nRules:");
        System.out.println("You have " + guess.getAttempts() + " attempts to guess the word.");
        System.out.println("If the letter is in the correct spot, it will show the letter");
        System.out.println("If the letter is correct but not in the right spot, it will show a *");
        System.out.println("If the letter is incorrect, it will show a -");
        System.out.println("For example, if you guess 'apple' and get A--*-, that means A is correct and L is in the wrong spot.");

        System.out.println("\nYour guess must be " + word.getLength() + " characters long.");
        boolean win = false;
        while (guess.getAttempts() > 0) {
            System.out.println("Please input your guess. You have " + guess.getAttempts() + " attempts remaining.");
            guess.setGuess(input.next());
            if (guess.getGuess().length() != word.getLength()) { // if the guess isn't the correct length
                while (guess.getGuess().length() != word.getLength()) {
                    System.out.println("Please input a guess " + word.getLength() + " characters long. Your guess was " + guess.getGuess().length() + " letters.");
                    guess.setGuess(input.next());
                }
            } // end if the guess isn't the correct length
            if (guess.test().equals(word.getWord())) {
                guess.setAttempts(0);
                win = true;
                System.out.println("Congratulations! You've guessed correctly!");
            } else {
                System.out.println("" + guess.test());
            }
            guess.subtract();
        } // attempts = 0
        if (!(win)) { // if the user didn't get the right answer
            System.out.println("Unfortunately, you've run out of turns. The correct answer was " + word.getWord() + ".");
        }
    }
}