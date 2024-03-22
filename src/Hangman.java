import java.util.Scanner;

public class Hangman {

    String word;
    int lives;
    char guess;
    boolean correct;
    int numberOfGuessedLetters;
    String entireGuess;



    public Hangman(String word, int lives) {
        this.word = word;
        this.lives = lives;
    }

    public void gamePlay() {
        Scanner scanner = new Scanner(System.in);


        //one method
        char[] mysteryWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            mysteryWord[i] = '_';
        }
        System.out.println("Word we are guessing is: " + String.valueOf(mysteryWord));
        System.out.println("It has " + word.length() + " letters");


        while (lives > 0) {
            System.out.println("Word: " + String.valueOf(mysteryWord));
            System.out.println("Tries left: " + lives + "\n");
            System.out.print("Guess a letter: ");

            //one method
            guess = scanner.next().charAt(0);
            correct = false;
            for (int i = 0; i < word.length(); i++) {

                if (word.charAt(i) == guess) {
                    mysteryWord[i] = guess;
                    correct = true;
                    numberOfGuessedLetters++;
                }
            }
            if (numberOfGuessedLetters > 0) {
                System.out.println("Guess is correct");
                System.out.println("You have guessed: " + guess + " and it is " + numberOfGuessedLetters + " times in the word");
                numberOfGuessedLetters=0;
            }
            if (!correct) {
                System.out.println("Wrong guess");
                lives--;
            }
            System.out.println("Word: " + String.valueOf(mysteryWord));
            System.out.print("Do you want to guess the whole word: ");
            entireGuess = scanner.next();
            if (entireGuess.equals(word)) {
                System.out.println("You have guessed the word!");
                System.out.println("The word is: " + word);
                return;
            } else {
                lives--;
                System.out.println("Wrong word");

            }
            if (String.valueOf(mysteryWord).equals(word)) {
                System.out.println("Congratulations! ");
                System.out.println("You have won! The word is: " + word);
                return;
            }
        }
    }
}
