import java.util.Scanner;


public class Main {
    static String word;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the hangman game!Let's play!");
        System.out.println("Give me a word,any word: ");

        word = scanner.nextLine();
        Hangman hangman = new Hangman(word, 16);
        hangman.GamePlay();
    }
}
