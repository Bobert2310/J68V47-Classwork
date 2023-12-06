package Lesson7;

import java.util.Random;
import java.util.Scanner;

public class Lesson7Exercise3_MightyMathsQuiz {

    private static int askQuestion(int number1, int number2, Scanner input) {
        System.out.print("What is " + number1 + " + " + number2 + "? ");
        return input.nextInt();
    }

    private static int correctAnswer(int score) {
        System.out.println("Correct!");
        return score + 1;
    }

    private static int wrongAnswer(int answer, int lives) {
        System.out.println("Wrong! The answer is " + answer);
        lives--;
        System.out.println("You have " + lives + " lives left.");
        return lives;
    }

    private static void gameOver(int score, int lives) {
        System.out.println("Game over. Your score is " + score);
        if (lives > 0) {
            System.out.println("Well done!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int lives = 3;
        int userAnswer;
        int answer;
        int count = 1;

        while (count <= 10 && lives > 0) {
            int number1 = random.nextInt(11);
            int number2 = random.nextInt(11);

            userAnswer = askQuestion(number1, number2, input);
            answer = number1 + number2;

            if (answer == userAnswer) {
                score = correctAnswer(score);
            } else {
                lives = wrongAnswer(answer, lives);
            }

            count++;
        }

        gameOver(score, lives);
    }
}