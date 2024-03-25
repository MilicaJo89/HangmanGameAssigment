import java.util.Scanner;

public class Hangman {

    String word;
    int lives;
    char guess;
    boolean correct;
    int numberOfGuessedLetters;
    String entireGuess;
    char[] mysteryWord;






    public Hangman(String word, int lives) {
        this.word = word;
        this.lives = lives;
    }

    public void SetUp(){
        mysteryWord=new char[word.length()];
        int i=0;
        for (char letter : word.toCharArray()){
            mysteryWord[i++]='_';
        }
        System.out.println("Word we are guessing is: "+ String.valueOf(mysteryWord));
        System.out.println("It has " + word.length()+" letters");
    }

    public void GuessLetter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Word: "+ String.valueOf(mysteryWord));
        System.out.println("Tries left: "+lives+"\n");
        System.out.print("Guess a letter: ");
        guess=scanner.next().charAt(0);
        int j=0;
        correct=false;
        numberOfGuessedLetters=0;
        for (char letter :word.toCharArray()) {
            if (letter == guess) {
                mysteryWord[j]=guess;
                correct = true;
                numberOfGuessedLetters++;}
            j++;
        }
        if (numberOfGuessedLetters > 0) {
                System.out.println("There is " + guess + " in the word");
                System.out.println("It can be found " + numberOfGuessedLetters + " times in the word");
        }
        if (!correct) {
                System.out.println("Wrong letter");
                lives--;
        }
    }

    public void GuessWord(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word: "+String.valueOf(mysteryWord));
        System.out.print("Try guessing the whole word: ");
        entireGuess=scanner.next();
        if (entireGuess.equals(word)){
            System.out.println("You have guessed the word!!");
            System.out.println("The word is "+word);
            System.out.println("Tries left: "+lives);

        }else {
            lives--;
            System.out.println("Wrong word!!");
        }
    }

    public void GamePlay(){


        SetUp();
        while (lives > 0){
            GuessLetter();
            if (String.valueOf(mysteryWord).equals(word)){
                System.out.println("Congratulations!!");
                System.out.println("You won!!!");
                System.out.println("The word is: "+ word);
                return;
            }
            GuessWord();
            if (String.valueOf(entireGuess).equals(word)){
                System.out.println("Congratulations!!");
                System.out.println("You won!!!");
                System.out.println("The word is: "+ word);
                return;
            }
        }
        System.out.println("You lost");
        System.out.println("The word was: "+ word);
    }
}
