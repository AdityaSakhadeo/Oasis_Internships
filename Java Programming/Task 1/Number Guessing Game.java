/*
Oasis Internships : Java Programming Internship
Task 1 : Number Guessing Game
Programmed By : Aditya Rajesh Sakhadeo  
*/

import java.util.Random;
import java.util.Scanner;

class numberGuess {
    int guessesO = 5;
    int guessesT = 10;
    int guessesTh = 20;
    int num = 0;
    int score = 100;
    int round = 1;
    int score_one, score_final;
    int max_score = 100;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    int createRandom() {
        if (round == 1) {
            num = random.nextInt(20);
            System.out.println(
                    "******************************************\nWelcome to round 1\nNumber assumed by the system is between 1-20\nNow try to guess it....\n******************************************");
        }
        if (round == 2) {
            num = random.nextInt(100);
            System.out.println(
                    "******************************************\nWelcome to round 2\nNumber assumed by the system is between 1-100\nNow try to guess it....\n******************************************");
        }
        if (round == 3) {
            num = random.nextInt(500);
            System.out.println(
                    "******************************************\nWelcome to round 3\nNumber assumed by the system is between 1-500\nNow try to guess it....\n******************************************");
        }
        sc.close();
        return num + 1;
    }

    void play(int num) {
        while (true) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            if (round == 1) {
                guessesO = guessesO - 1;
                System.out.println("Number of gusses remaining: " + (guessesO));
                if (guessesO == 0) {
                    System.out.println("Game Over!!!!\nEnd of gusses");
                    System.out.println("The number was " + num);
                    break;
                }
            }
            if (round == 2) {
                guessesT = guessesT - 1;
                System.out.println("Number of gusses remaining: " + (guessesT));
                if (guessesT == 0) {
                    System.out.println("Game Over!!!!\nEnd of gusses");
                    System.out.println("The number was" + num);
                    break;
                }
            }
            if (round == 3) {
                guessesTh = guessesTh - 1;
                System.out.println("Number of gusses remaining: " + (guessesTh));
                if (guessesTh == 0) {
                    System.out.println("Game Over!!!!\nEnd of gusses");
                    System.out.println("The number was " + num);
                    break;
                }
            }
            if (guess < num) {
                System.out.println("Your number is lower...");
            }
            if (guess > num) {
                System.out.println("Your number is higher...");

            }
            if (guess == num) {
                System.out.println(
                        "++++++++++++++++++++++++++++++++++++++++\nYou guessed the correct number\n++++++++++++++++++++++++++++++++++++++++");
                round = round + 1;
                if (round <= 3) {
                    int newN = createRandom();
                    play(newN);
                }
                break;
            }
        }
        if (guessesO*guessesT*guessesTh==0) 
        {
           score_final=0; 
        }
        else
        {
            score_one=guessesO+guessesT+guessesTh;
            score_final=score_one*10; 
        }
    round=1;
    guessesO=5;
    guessesT=10;
    guessesTh=20;
    System.out.println("Your score is: " + score_final+"/350");
    }

}

public class Task1 {
    public static void main(String[] args) {
        numberGuess ng = new numberGuess();
        Scanner sc = new Scanner(System.in);
        int play_again = 1;
        System.out.println(
                "Rules Of the Game :\n1)The game consists of three rounds. Each round has a different range of numbers and a specific number of guesses allowed.\n2)Each round will have different range of numbers and guesses allowed.\nRound Number -> Range -> Number of guessesRound\nround -> 1-20 -> 5\nRound two -> 1-100 -> 10\nRound three -> 1-500 -> 20\n3)Your Score will be maximized if you use minimum number of guesses.");
        while (true) {
            if (play_again == 1) {
                int num = ng.createRandom();
                ng.play(num);
                System.out.println("Play Again??\nPress 1 to play again and 0 to quit....");
                play_again = sc.nextInt();

            } else {
                break;
            }
        }
        sc.close();
    }
}
