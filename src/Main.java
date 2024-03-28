import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<String>words=WordReader.WordReader("src/Resource/GameWords.csv");
        Random random = new Random();
        String gameWord=words.get(random.nextInt(words.size()));
        System.out.println("Welcome to the hangman game!Let's play!");
        System.out.println("Give me a word,any word: ");
        Hangman hangman = new Hangman(gameWord, 16);
        hangman.GamePlay();
    }
}