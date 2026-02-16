//task 6
// Work 6
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HANGMAN6 {
    public static void main(String[] args) {

        // Instead of reading from a file, use a hardcoded list
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("orange");
        words.add("grape");
        words.add("melon");
        words.add("kiwi");

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        for(int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("\n--- MAN HANG  ---");

        while(wrongGuesses < 6) {
            System.out.print(getHangmanArt(wrongGuesses));

            System.out.print("Word: ");
            for(char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct Guess!\n");
                for(int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }
                if (!wordState.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("You win!");
                    System.out.println("The word was: " + word);
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong Guess!\n");
            }
        }

        if (wrongGuesses >= 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("Game Over!");
            System.out.println("The word was: " + word);
        }

        scanner.close();
    }

   static String getHangmanArt(int wrongGuesses) {
    switch (wrongGuesses) {
        case 0:
            return "   |\n" +
                   "  / \n" +
                   "     \n" +
                   "     \n" +
                   "     \n" +
                   "     \n";
        case 1:
            return "   |\n" +
                   "  / o\n" +
                   "     \n" +
                   "     \n" +
                   "     \n" +
                   "     \n";
        case 2:
            return "   |\n" +
                   "  / o\n" +
                   "    |\n" +
                   "     \n" +
                   "     \n" +
                   "     \n";
        case 3:
            return "  /|\n" +
                   "  / o\n" +
                   "   /|\n" +
                   "     \n" +
                   "     \n" +
                   "     \n";
        case 4:
            return "  /|\n" +
                   "  / o\n" +
                   "   /|\\\n" +
                   "     \n" +
                   "     \n" +
                   "     \n";
        case 5:
            return "  /|\n" +
                   "  / o\n" +
                   "   /|\\\n" +
                   "   / \n" +
                   "     \n" +
                   "     \n";
        case 6:
            return "  /|\n" +
                   "  / o\n" +
                   "   /|\\\n" +
                   "   / \\\n" +
                   "     \n" +
                   "     \n";
        default:
            return "";
    }
}
}
